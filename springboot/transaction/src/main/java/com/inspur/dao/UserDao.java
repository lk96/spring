package com.inspur.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspur.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
}
