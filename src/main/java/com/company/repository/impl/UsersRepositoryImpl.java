package com.company.repository.impl;

import com.company.repository_spring_data.UserRepository;
import com.company.enums.Role;
import com.company.dto.User;
import com.company.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    private UserRepository userRepository; // Spring data repo


    public void initiateUsersRepo(){

        if(userRepository.findByLogin("user")==null && userRepository.findByLogin("admin")== null) {
            User admin = new User("admin", "admin", "admin", "admin", Role.ADMINISTRATOR);
            User user = new User("user", "user", "user", "user", Role.USER);
            userRepository.save(admin);
            userRepository.save(user);
        }

    }










}
