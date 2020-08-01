package com.estadisticacovid.FrancoBorsani.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.estadisticacovid.FrancoBorsani.helpers.ViewRouteHelpers;

@Controller	
@RequestMapping("/")
public class UserController {	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.WEB_INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("username", user.getUsername());
		return mAV;
	}
	
	//PERMISOS DE ADMIN
	//@PreAuthorize("hasRole('ROLE_ADMIN")");
	
	
	@GetMapping("/login")
	public String login(Model model,
			@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelpers.USER_LOGIN;
		
	}
	
	@GetMapping("/logout")
	public String logout (Model model) {
		return ViewRouteHelpers.USER_LOGOUT;
		
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/index";
	}
	
	
}
