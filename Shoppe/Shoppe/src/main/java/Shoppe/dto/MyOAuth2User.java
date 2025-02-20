package Shoppe.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import Shoppe.persistence.model.Privilege;
import Shoppe.persistence.model.Role;
import Shoppe.persistence.model.User;



public class MyOAuth2User implements OAuth2User {

	private User user;
	
	
	public MyOAuth2User(User user) {
		super();
		this.user = user;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role>  roles = user.getRoles();
		
		return getGrantedAuthorities(getPrivileges(roles));
	}
	private List<String> getPrivileges(List<Role> roles) {
		 
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
