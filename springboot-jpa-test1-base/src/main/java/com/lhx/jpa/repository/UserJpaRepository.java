package com.lhx.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lhx.jpa.entity.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
