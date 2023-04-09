package com.tejas.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests((request) -> request.requestMatchers("/admin").hasRole("ADMIN")
						.requestMatchers("/extendedUser").hasAnyRole("EXTUSER", "ADMIN").requestMatchers("/user")
						.hasAnyRole("USER", "EXTUSER", "ADMIN").anyRequest().authenticated())
				.formLogin().and().logout().and().csrf().disable().build();

	}

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
