package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserI userS;

    @RequestMapping("/user/list")
    public String home(final Model model) {
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("User list displayed");
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(final User bid) {
        LOGGER.debug("Entering the new User");
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid final User user,
                           final BindingResult result, final Model model) {
        if (!result.hasErrors()) {
            userS.postUser(user);
            model.addAttribute("users", userS.getUsers());
            LOGGER.info("User added");
            return "redirect:/user/list";
        }
        LOGGER.error("Entry error");
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        User user = userS.getUser(id);
        user.setPassword("");
        model.addAttribute("user", user);
        LOGGER.debug("User modification");
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") final Integer id,
                             @Valid final User user,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "user/update";
        }

        user.setId(id);
        userS.postUser(user);
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("Modified user");
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") final Integer id,
                             final Model model) {
        userS.deleteUser(id);
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("User delete");
        return "redirect:/user/list";
    }
}
