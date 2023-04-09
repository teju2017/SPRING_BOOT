package com.tejas.springboot.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ReadAccessFile {

	private final String filename = "src\\main\\resources\\access.txt";

	private Map<String, String[]> userDetailsMap = new HashMap<>();

	public UserDetails getUserDetails(String username) {
		String[] userDetails;
		userDetails = getRolesBasedOnUsername(username);
		PasswordEncoder pwc = new BCryptPasswordEncoder();
		System.out.println("user= " + userDetails[0] + " password = " + userDetails[1] + "  authorities= "
				+ userDetails[2] + " roles= " + userDetails[3]);
		return User.withUsername(userDetails[0]).password(pwc.encode(userDetails[1])).authorities(userDetails[2])
				.roles(userDetails[3]).build();

	}

	public Map<String, String[]> loadFileDetails(String username) {
		try {
			File f = new File(filename);
			String[] userInfo = null;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
				String line;
				while ((line = br.readLine()) != null) {
					
					userInfo = line.split("\\|");
					if (userInfo.length == 4) {
						System.out.println("username loading = "+userInfo[0]);
						userDetailsMap.put(userInfo[0], userInfo);
					}

				}

			}
		} catch (Exception ae) {
			System.out.println("Some issue in getting the userDetails loaded " + ae.getMessage());
		}
		return userDetailsMap;
	}

	private String[] getRolesBasedOnUsername(String username) {
		if(userDetailsMap.size() == 0)
		{
		    loadFileDetails(username);
		}
		String[] userDetails = null;
		PasswordEncoder pwc = new BCryptPasswordEncoder();
		if (userDetailsMap.containsKey(username)) {
			userDetails = userDetailsMap.get(username);
		}
		return userDetails;

	}

}
