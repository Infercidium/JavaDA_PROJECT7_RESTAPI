package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger LOGGER
			= LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(final Model model) {
		LOGGER.info("Home page display");
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(final Model model) {
		LOGGER.info("Display of the admins home page");
		return "redirect:/bidList/list";
	}


}
