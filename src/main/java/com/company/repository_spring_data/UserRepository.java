package com.company.repository_spring_data;

import com.company.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findByLogin(String login);


}
