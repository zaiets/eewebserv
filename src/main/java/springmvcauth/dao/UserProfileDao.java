package springmvcauth.dao;

import springmvcauth.model.UserProfile;

import java.util.Set;


public interface UserProfileDao {

	Set<UserProfile> findAll();
	
	UserProfile findByRole(String role);
	
	UserProfile findById(int id);
}
