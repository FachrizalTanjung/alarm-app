package com.alarm.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alarm.app.model.User;

public interface UserDao extends JpaRepository<User, String> {

}
