package com.example.rentalproperty.service.impl;

import com.example.rentalproperty.dto.UserAfterCreatingDto;
import com.example.rentalproperty.dto.UserCreateDto;
import com.example.rentalproperty.entity.User;
import com.example.rentalproperty.entity.UserInfo;
import com.example.rentalproperty.exception.TenantDoesntExistException;
import com.example.rentalproperty.exception.errorMessage.ErrorMessage;
import com.example.rentalproperty.mapper.UserMapper;
import com.example.rentalproperty.repository.UserInfoRepository;
import com.example.rentalproperty.repository.UserRepository;
import com.example.rentalproperty.service.UserServices;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
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
}
