package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/**
	 * Instantiation of LOGGER in order to inform in console.
	 */
	private static final Logger LOGGER
			= LoggerFactory.getLogger(HomeController.class);

	/**
	 * Default page to access the application.
	 * @param model : use by spring.
	 * @return the start page.
	 */
	@RequestMapping("/")
	public String home(final Model model) {
		LOGGER.info("Home page display");
		return "home";
	}

	/**
	 * Home page of admins.
	 * @param model : use by spring.
	 * @return the admins page.
	 */
	@RequestMapping("/admin/home")
	public String adminHome(final Model model) {
		LOGGER.info("Display of the admins home page");
		return "redirect:/bidList/list";
	}
}
