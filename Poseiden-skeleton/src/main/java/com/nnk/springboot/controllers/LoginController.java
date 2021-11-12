package com.nnk.springboot.controllers;

import com.nnk.springboot.service.UserI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("app")
public class LoginController {

    /**
     * Instantiation of LOGGER in order to inform in console.
     */
    private static final Logger LOGGER
            = LoggerFactory.getLogger(LoginController.class);

    /**
     * Instantiation of userInterface.
     */
    @Autowired
    private UserI userS;

    /**
     * Links to the login page.
     * @return the login page.
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        LOGGER.info("User login");
        return mav;
    }

    /**
     * Refers to the page listing the users.
     * @return the list of users.
     */
    @GetMapping("secure/article-details")
    public ModelAndView getAllUserArticles() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userS.getUsers());
        mav.setViewName("user/list");
        LOGGER.info("User list displayed");
        return mav;
    }

    /**
     * Installation of the error page.
     * @return the error page.
     */
    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage = "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        LOGGER.error("Error detected");
        return mav;
    }
}
