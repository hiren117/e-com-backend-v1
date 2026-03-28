package com.kashima.ecom_backend.service;

import com.kashima.ecom_backend.exception.UserException;
import com.kashima.ecom_backend.model.User;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface UserService {

    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;

    public List<User> findAllUsers();
}