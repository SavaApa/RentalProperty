package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    UserInfo findByEmail(String email);
}
