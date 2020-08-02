package com.estadisticacovid.FrancoBorsani.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estadisticacovid.FrancoBorsani.models.UserModel;
import com.estadisticacovid.FrancoBorsani.repositories.IUserRepository;

@Controller	
@RequestMapping("/userRest")
public class UserRestController {
	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> allUsers() {
		List<UserModel> users = new ArrayList<UserModel>();	
		users.add(new UserModel(1, "Franco", "admin", true));
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}

}
