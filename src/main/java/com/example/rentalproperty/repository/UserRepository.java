package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserById(UUID id);

    @Query("SELECT u FROM User u WHERE u.userInfo.userName = :username")
    Optional<User> findByUserInfoUserName(@Param("username") String username);

}
