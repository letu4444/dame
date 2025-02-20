package Shoppe.config.autho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import Shoppe.persistence.dao.UserRepository;
import Shoppe.persistence.model.User;
import Shoppe.serviecs.DefaultUserService;
import Shoppe.uitl.UserUtil;



@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
	private DefaultUserService defaultUserService;
    @Autowired
    private UserUtil userUtil;
    
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String clientName = userRequest.getClientRegistration().getClientName();
        OAuth2User user =  super.loadUser(userRequest);
//        MyUser myuser = new MyUser();
        User userdto = new User();
        if(userRepository.findByUsername(user.<String>getAttribute("name")) == null){
        	userdto.setEmail(user.<String>getAttribute("email"));
        	userdto.setUsername(user.<String>getAttribute("name"));
        	userdto.setImage(user.<String>getAttribute("picture"));
        }else {
        userdto = userRepository.findByUsername(user.<String>getAttribute("name"));
        	
//        	 userUtil.setUser(userdto);
		}
       
        return new CustomOAuth2User(clientName, user, userdto);
    }
 
}
