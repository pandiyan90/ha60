package com.healthabove60.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.healthabove60.dto.UserDTO;
import com.healthabove60.jpa.entity.User;
import com.healthabove60.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@ControllerAdvice
@Slf4j
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping({"/","/login"})
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/registration")
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("user", new UserDTO());
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@PostMapping("/registration")
	public ModelAndView createNewUser(UserDTO userDTO, BindingResult bindingResult, ModelMap modelMap) {
		if(bindingResult.hasErrors())
			log.error("Errors: "+bindingResult.getAllErrors());
		User user = userService.findUser(userDTO.getEmail());
		ModelAndView modelAndView = new ModelAndView();
		if(null==user){
			userService.createNewUser(userDTO);
			modelAndView.setViewName("login");
		}else
			modelAndView.setViewName("registration");
		return modelAndView;
	}

	@GetMapping("/admin/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}

	@GetMapping("/admin/users")
	@ResponseBody
	public List<User> users() {
		return userService.findAllUsers();
	}

}