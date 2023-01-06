
package com.allenfc.rest.webservices.restfullwebservices.security;

import java.util.Arrays;
import java.util.Collections;

import javax.sql.DataSource;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private UserDetailsService userDetailsService;
	
	// authenticate jdbc users
	@Override
	public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService(userDetailsService);
			/*.jdbcAuthentication()
				.dataSource(dataSource)
					.passwordEncoder(new BCryptPasswordEncoder())
					.usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
					.authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?");*/
				
	}

	@Override
	public void configure (HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors().configurationSource(corsConfigurationSource())
			.and()
			.authorizeRequests()
				.antMatchers("/*").permitAll()
				//.anyRequest().authenticated()
			.and()
				.formLogin().permitAll()//.successHandler(appAuthenticationSuccessHandler())
			.and()
				.logout().permitAll();
			
		//return http.build();
		
				// testing , "/users/username/**"

				
	}

	
	  @Bean public CorsConfigurationSource corsConfigurationSource() { final
	  CorsConfiguration configuration = new CorsConfiguration();
	  UrlBasedCorsConfigurationSource source = new
	  UrlBasedCorsConfigurationSource();
	  
	  configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	  configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
	  "DELETE")); configuration.setAllowCredentials(true);
	  configuration.setAllowedHeaders(Arrays.asList("Authorization",
	  "Cache-Control", "Content-Type")); configuration.setMaxAge(3600L);
	  //configuration.addAllowedHeader("{`Content-Type`: `application/json`}");
	  source.registerCorsConfiguration("/**", configuration); return source; }
	 
	
	/*
	 * @Bean public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
	 * return new AppAuthenticationSuccessHandler(); }
	 * 
	 * @Override public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 */
	
}
















