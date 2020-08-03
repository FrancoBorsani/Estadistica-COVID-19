package com.estadisticacovid.FrancoBorsani.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.estadisticacovid.FrancoBorsani.helpers.ViewRouteHelpers;
import com.estadisticacovid.FrancoBorsani.implementation.UserRoleService;
import com.estadisticacovid.FrancoBorsani.repositories.IUserRepository;
import com.estadisticacovid.FrancoBorsani.repositories.IUserRoleRepository;

@Controller	
@RequestMapping("/")
public class UserController {	

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	@Autowired
	@Qualifier("userRoleRepository")
	private IUserRoleRepository userRoleRepository;
	@Autowired
	@Qualifier("userRoleService")
	private UserRoleService userRoleService;


	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.WEB_INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("username", user.getUsername());
		return mAV;
	}


	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/masdatos")
	public ModelAndView masDatos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.WEB_MAS_DATOS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mAV.addObject("username", user.getUsername());
		return mAV;
	}

	@GetMapping("/login")	
	public String login(Model model,	
			@RequestParam(name="error",required=false) String error,	
			@RequestParam(name="logout", required=false) String logout) {	
		System.out.println("Entró de ruta");
		if(error!=null){
			model.addAttribute("error", error);
		}

		model.addAttribute("logout", logout);

		String username = "";
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true); 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}
		System.out.println(username);
		if(!username.isEmpty()) {
			System.out.println("Ya esta logueado. Primero deberia desloguearse");
			return "redirect:/";
		}
		else {
			return ViewRouteHelpers.USER_LOGIN;
		}
	}	

	@GetMapping("/logout/")	
	public String logout(Model model,	
			@RequestParam(name="error",required=false) String error,	
			@RequestParam(name="logout", required=false) String logout) {	
		if(error!=null){
			model.addAttribute("error", error);
		}

		model.addAttribute("logout", logout);

		String username = "";
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false); 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		}
		System.out.println(username);
		if(!username.isEmpty()) {
			System.out.println("Ya esta logueado. Primero deberia desloguearse");
			return "redirect:/";
		}
		else {
			return ViewRouteHelpers.USER_LOGOUT;
		}

	}



		//String username = "";
	//	System.out.println("DESLOGUEADO1");
		//	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//	if (principal instanceof UserDetails) {
		//	  username = ((UserDetails)principal).getUsername();
		//	}
		//	System.out.println(username);
		//	if(username.isEmpty()) {
		//		System.out.println("no hay ninguna cuenta logueada");
		//			return "redirect:/";	
		//		}
		//	else{	
		//SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false); 
		//System.out.println("DESLOGUEADO");
		//return ViewRouteHelpers.USER_LOGOUT;

	//}



	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/index";
	}


}
