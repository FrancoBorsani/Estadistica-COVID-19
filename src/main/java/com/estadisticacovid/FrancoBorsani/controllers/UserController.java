package com.estadisticacovid.FrancoBorsani.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estadisticacovid.FrancoBorsani.helpers.ViewRouteHelpers;

@Controller	
@RequestMapping("/web")
public class UserController {	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.WEB_INDEX);
		return mAV;
		
	}
	
}
