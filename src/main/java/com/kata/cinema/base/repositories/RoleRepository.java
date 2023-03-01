package com.kata.cinema.base.repositories;

import com.kata.cinema.base.models.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select role from Role role where role.name = ?1")
    Role getByName(String name);
}

