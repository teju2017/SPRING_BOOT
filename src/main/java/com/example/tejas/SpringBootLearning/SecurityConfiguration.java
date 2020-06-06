package com.example.tejas.SpringBootLearning;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/*        Spring securityConfiguration class to allow
 *        the request coming with "console", this is to 
 *        enable the h2-console link 
 *       
 */


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	  @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
	                .authorizeRequests().antMatchers("/console/**").permitAll();
	        httpSecurity.csrf().disable();
	        httpSecurity.headers().frameOptions().disable();
	        
	  }


}
