package com.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
