package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserI extends UserDetailsService {
    //Service
    void postUser(User user);

    User getUser(int id);

    List<User> getUsers();

    void deleteUser(int id);
}
