package com.tejas.springboot.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationInfoProvider implements AuthenticationInfo {

	@Override
	public Authentication getAuthentication() {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}

}
