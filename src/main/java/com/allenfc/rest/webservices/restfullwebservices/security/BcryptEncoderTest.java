
package com.allenfc.rest.webservices.restfullwebservices.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedString1 = encoder.encode("pass");
		Boolean matches = encoder.matches("pass", encodedString1);
		
		System.out.println(encodedString1);
		System.out.println(matches);
		
		/*
		 * for(int i = 1; i <= 10; i++) { String encodedString = encoder.encode("pass");
		 * System.out.println(encodedString); }
		 */
		
		
	}

}
