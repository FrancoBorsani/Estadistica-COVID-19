package com.estadisticacovid.FrancoBorsani.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.estadisticacovid.FrancoBorsani.repositories.IUserRoleRepository;

@Service("userRoleService")
public class UserRoleService {
	
	@Autowired
	@Qualifier("userRoleRepository")
	public IUserRoleRepository userRoleRepository;
	
	public void saveUser(com.estadisticacovid.FrancoBorsani.entities.UserRole user) {
		userRoleRepository.save(user);
	}

}
