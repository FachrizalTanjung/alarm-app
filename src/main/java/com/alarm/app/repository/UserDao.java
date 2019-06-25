package com.alarm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alarm.app.model.User;

public interface UserDao extends JpaRepository<User, String> {

}
