package com.company.service;

import com.company.dto.User;

import com.company.exceptions.SuchUserExists;
import com.company.exceptions.UserNotFound;
import com.company.exceptions.WrongPasswordException;

public interface UserService {

    public void addUser(User user) throws SuchUserExists;

    public User getUser(String login);

    public void checkLoginAndPassword(String login, String password) throws WrongPasswordException, UserNotFound;

    public void checkExistanceOfUser(String login) throws SuchUserExists;
}
