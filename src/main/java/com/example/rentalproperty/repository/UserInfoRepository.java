package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.UserInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, UUID> {

    @EntityGraph(attributePaths = "roles")
    Optional<UserInfo> findByUserName(String name);
}
