package com.example.rentalproperty.repository;

import com.example.rentalproperty.entity.Role;
import com.example.rentalproperty.entity.enums.RoleName;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    @EntityGraph(attributePaths = "authorities")
    Role findByRoleName(RoleName roleName);

    Optional<Role> findById(UUID roleId);
}
