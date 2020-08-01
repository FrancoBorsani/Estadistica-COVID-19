package com.estadisticacovid.FrancoBorsani.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estadisticacovid.FrancoBorsani.entities.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Serializable>{
	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.username = (:username)")
	public abstract User findByUsernameAndFetchUserRolesEagerly(@Param("username") String username);
	
	@Query("SELECT u FROM User u JOIN FETCH u.userRoles WHERE u.id= (:id)")
	public abstract User findByIdAndFetchUserRolesEagerly(@Param("id") long id);

	
}