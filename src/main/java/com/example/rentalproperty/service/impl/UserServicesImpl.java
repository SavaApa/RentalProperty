package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.Authority;
import com.example.rentalproperty.entity.Role;
import com.example.rentalproperty.entity.User;
import com.example.rentalproperty.entity.UserInfo;
import com.example.rentalproperty.entity.enums.RoleName;
import com.example.rentalproperty.exception.TenantDoesntExistException;
import com.example.rentalproperty.exception.UserDoesntExistException;
import com.example.rentalproperty.exception.errorMessage.ErrorMessage;
import com.example.rentalproperty.mapper.UserMapper;
import com.example.rentalproperty.repository.AuthorityRepository;
import com.example.rentalproperty.repository.RoleRepository;
import com.example.rentalproperty.repository.UserInfoRepository;
import com.example.rentalproperty.repository.UserRepository;
import com.example.rentalproperty.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public User getUserById(UUID id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new TenantDoesntExistException(ErrorMessage.NOT_EXIST);
        }
        return user;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserAfterCreatingDto createUser(UserCreateDto userCreateDto) {
        Optional<User> existingUser = userRepository.findByUserInfoUserName(userCreateDto.getUserName());
        if (existingUser.isPresent()) {
            throw new UserDoesntExistException("User with userName: " + userCreateDto.getUserName() + " already exists");
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userCreateDto.getUserName());
        userInfo.setEmail(userCreateDto.getEmail());
        userInfo.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        UserInfo savedUserInfo = userInfoRepository.save(userInfo);

        Role role = roleRepository.findByRoleName(RoleName.ROLE_ADMIN);
        if (role == null) {
            role = new Role();
            role.setRoleName(RoleName.ROLE_ADMIN);
            role = roleRepository.save(role);
        }

        User user = new User();
        user.setUserInfo(savedUserInfo);
        user.setFirstName(userCreateDto.getFirstName());
        user.setLastName(userCreateDto.getLastName());
        user.setUserInfo(savedUserInfo);

        User savedUser = userRepository.save(user);

        Authority authority = new Authority();
        authority.setAuthorityName(RoleName.ROLE_ADMIN.name());
        authority.setRoles(Collections.singleton(role));
        authorityRepository.save(authority);

        UserAfterCreatingDto userAfterCreationDto = userMapper.toDto(savedUser);
        userAfterCreationDto.setUserId(String.valueOf(savedUser.getId()));

        return userAfterCreationDto;
    }

    @Override
    public void deleteUserById(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new UserDoesntExistException(ErrorMessage.NOT_EXIST);
        }
    }

    @Override
    @Transactional
    public User updateUser(UUID id, User user) {
        User getUser = getUserById(id);
        if (getUser != null) {
            if (!Objects.equals(getUser.getFirstName(), user.getFirstName())) {
                getUser.setFirstName(user.getFirstName());
            }
            if (!Objects.equals(getUser.getLastName(), user.getLastName())) {
                getUser.setLastName(user.getLastName());
            }
            UserInfo userToUpdateInfo = getUser.getUserInfo();
            UserInfo userInfoFromRequest = user.getUserInfo();
            if (userToUpdateInfo != null && userInfoFromRequest != null) {
                if (!Objects.equals(userToUpdateInfo.getUserName(), userInfoFromRequest.getUserName())) {
                    userToUpdateInfo.setUserName(userInfoFromRequest.getUserName());
                }
                if (!Objects.equals(userToUpdateInfo.getPassword(), userInfoFromRequest.getPassword())) {
                    userToUpdateInfo.setPassword(userInfoFromRequest.getPassword());
                }
                if (!Objects.equals(userToUpdateInfo.getEmail(), userInfoFromRequest.getEmail())) {
                    userToUpdateInfo.setEmail(userInfoFromRequest.getEmail());
                }
            }
            userRepository.save(getUser);
            return getUser;
        }
        return null;
    }
}

