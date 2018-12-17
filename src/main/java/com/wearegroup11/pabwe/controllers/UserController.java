package com.wearegroup11.pabwe.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wearegroup11.pabwe.models.User;
import com.wearegroup11.pabwe.services.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView signIn() {
		ModelAndView model = new ModelAndView();
		model.setViewName("auth/signin");
		
		return model;
	}
	
	@RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("user", user);
		model.setViewName("auth/signup");

		return model;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView model = new ModelAndView();
		User userExist = userService.findByEmail(user.getEmail());

		if (userExist != null) {
			bindingResult.rejectValue("email", "error.user", "This email already exist!");
		}
		
		if (bindingResult.hasErrors()) {
			model.setViewName("auth/signup");
		} else {
			userService.save(user);
			model.addObject("msg", "User has been registered successfully!");
			model.addObject("user", new User());
			model.setViewName("auth/signup");
		}

		return model;
	}

	@RequestMapping(value = {"/access_denied"}, method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("errors/access_denied");
		return model;
	}
}
