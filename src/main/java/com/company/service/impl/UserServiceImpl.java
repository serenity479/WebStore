package com.company.service.impl;

import com.company.repository_spring_data.UserRepository;
import com.company.dto.User;
import com.company.exceptions.SuchUserExists;
import com.company.exceptions.UserNotFound;
import com.company.exceptions.WrongPasswordException;

import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) throws SuchUserExists {
        userRepository.save(user);
    }


    public User getUser(String login){
        return userRepository.findByLogin(login);
    }


    public void checkLoginAndPassword(String login, String password) throws WrongPasswordException, UserNotFound {

        User user = userRepository.findByLogin(login);
        if(user == null){
            throw new UserNotFound();
        }
        if(!password.equals(user.getPassword())){
            throw new WrongPasswordException();
        }
    }


    public void checkExistanceOfUser(String login) throws SuchUserExists {
        User user = userRepository.findByLogin(login);
        if(user != null){
            throw new SuchUserExists();
        }
    }

}
