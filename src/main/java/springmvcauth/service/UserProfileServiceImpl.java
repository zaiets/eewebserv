package springmvcauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvcauth.dao.UserProfileDao;
import springmvcauth.model.UserProfile;

import java.util.Set;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	
	public UserProfile findById(int id) {
		return dao.findById(id);
	}

	public UserProfile findByType(String type){
		return dao.findByRole(type);
	}

	public Set<UserProfile> findAll() {
		return dao.findAll();
	}
}
