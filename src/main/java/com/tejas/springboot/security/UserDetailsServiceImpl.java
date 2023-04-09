
package com.tejas.springboot.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.tejas.springboot.services.ReadAccessFile;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ReadAccessFile fileread;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username passed to loadUserByUsername method is  " + username);
		UserDetails user = fileread.getUserDetails(username);
		if (user == null) {
			System.out.println("UserNameNotFound Exception");
		}
		Collection<? extends GrantedAuthority> authoritylist = user.getAuthorities();
		return new User(user.getUsername(), user.getPassword(), user.getAuthorities());

	}

}
