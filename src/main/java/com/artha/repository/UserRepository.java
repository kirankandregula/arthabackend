package com.artha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artha.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
