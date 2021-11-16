package com.nnk.springboot.service;

import com.nnk.springboot.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserI extends UserDetailsService {
    //Service
    /**
     * Add / Update a user in the database.
     * @param user : to add / update.
     */
    void postUser(User user);

    /**
     * Find the user who has the provided id.
     * @param id : to find.
     * @return the user.
     */
    User getUser(int id);

    /**
     * Find all users.
     * @return the list of users.
     */
    List<User> getUsers();

    /**
     * Removes the user with the provided id.
     * @param id : to delete.
     */
    void deleteUser(int id);
}
