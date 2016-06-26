package app.services;

import app.entities.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: "+ email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return  new org.springframework.security.core.userdetails.User
          (user.getEmail(), 
          user.getPassword().toLowerCase(), enabled, accountNonExpired, credentialsNonExpired, 
            accountNonLocked, getAuthorities(user.getRole().ordinal()));
    }
     
    private Collection<? extends GrantedAuthority> getAuthorities(Integer role){
        return getGrantedAuthorities(getRoles(role));
    }
    private List<String> getRoles(Integer role) {
        List<String> roles = new ArrayList<>();
        if (role == 0) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");
        } else if (role == 1) {
            roles.add("ROLE_USER");
        }
        return roles;
    }   
    private static List<GrantedAuthority> getGrantedAuthorities (List<String> roles) {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}