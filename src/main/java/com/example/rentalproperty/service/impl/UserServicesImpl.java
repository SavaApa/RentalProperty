package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
import com.example.rentalproperty.entity.UserInfo;
import com.example.rentalproperty.exception.TenantDoesntExistException;
import com.example.rentalproperty.exception.UserDoesntExistException;
import com.example.rentalproperty.exception.errorMessage.ErrorMessage;
import com.example.rentalproperty.mapper.UserMapper;
import com.example.rentalproperty.repository.UserInfoRepository;
import com.example.rentalproperty.repository.UserRepository;
import com.example.rentalproperty.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserService {

    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;

    @Override
    public User getUserById(UUID id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new TenantDoesntExistException(ErrorMessage.NOT_EXIST);
        }
        return user;
    }

    @Override
    @Transactional
    public UserAfterCreatingDto createUser(UserCreateDto userCreateDto) {
        UserInfo userInfo = userInfoRepository.findByEmail(userCreateDto.getEmail());
        if (userInfo != null) {
            throw new RuntimeException("User with email already exists");
        }

        User user = userMapper.toEntity(userCreateDto);
        userInfo = new UserInfo();
        userInfo.setEmail(userCreateDto.getEmail());
        userInfo.setPassword(userCreateDto.getPassword());
        userInfo.setUserName(userMapper.createUserName(userCreateDto));

        user.setUserInfo(userInfo);
        User userAfterCreating = userRepository.save(user);

        return userMapper.toDto(userAfterCreating);
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

