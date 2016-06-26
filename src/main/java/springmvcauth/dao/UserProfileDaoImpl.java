package springmvcauth.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springmvcauth.model.UserProfile;

import java.util.HashSet;
import java.util.Set;


@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile>implements UserProfileDao{

	public UserProfile findById(int id) {
		return getByKey(id);
	}

	public UserProfile findByRole(String role) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("role", role));
		return (UserProfile) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Set<UserProfile> findAll(){
		Criteria crit = createEntityCriteria();
		Set<UserProfile> set = new HashSet<>();
		set.addAll(crit.list());
		return set;
	}
	
}
