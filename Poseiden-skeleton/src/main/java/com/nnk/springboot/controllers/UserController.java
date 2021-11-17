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

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserController.class);

    /**
     * Instantiation of userInterface.
     */
    @Autowired
    private UserI userS;

    /**
     * Displays the list of user on the relevant page.
     * @param model : the list to display on the page.
     * @return the html page.
     */
    @RequestMapping("/user/list")
    public String home(final Model model) {
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("User list displayed");
        return "user/list";
    }

    /**
     * Displays the user add page.
     * @param user : to add.
     * @return the html page.
     */
    @GetMapping("/user/add")
    public String addUser(final User user) {
        LOGGER.debug("Entering the new User");
        return "user/add";
    }

    /**
     * Adds the entered User to the database.
     * @param user : to add.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the user list if no error, otherwise the add page.
     */
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

    /**
     * Displays the user edit page.
     * @param id : user to modify.
     * @param model : displays the concerned user.
     * @return the html page.
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") final Integer id,
                                 final Model model) {
        User user = userS.getUser(id);
        user.setPassword("");
        model.addAttribute("user", user);
        LOGGER.debug("User modification");
        return "user/update";
    }

    /**
     * Modifies the User entered the database.
     * @param id : user to modify.
     * @param user : modified user.
     * @param result : check if there is an error.
     * @param model : the list to display on the next page.
     * @return the User list if no error, otherwise the modification page.
     */
    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") final Integer id,
                             @Valid final User user,
                             final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            LOGGER.error("Entry error");
            return "user/update";
        }
        userS.updateUser(user, id);
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("Modified user");
        return "redirect:/user/list";
    }

    /**
     * Removes the selected User from the database.
     * @param id : user to delete.
     * @param model : the list to display on the next page.
     * @return the list of user.
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") final Integer id,
                             final Model model) {
        userS.deleteUser(id);
        model.addAttribute("users", userS.getUsers());
        LOGGER.info("User delete");
        return "redirect:/user/list";
    }
}
