package com.tejas.springboot.security;

import org.springframework.security.core.Authentication;

public interface AuthenticationInfo {
	
	Authentication getAuthentication();

}
