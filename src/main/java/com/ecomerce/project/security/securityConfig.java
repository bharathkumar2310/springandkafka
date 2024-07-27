package com.ecomerce.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class securityConfig {
	
	
	
	//create custom userDetails
//	@Bean
//	UserDetailsService userDetailsService() {
//		//InMemoryUserDetailsManager : A simple implementation of UserDetailsService that stores user details in memory. It is useful for development and testing but not recommended for production use due to its lack of persistence.
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//		UserDetails user = User.withUsername("bharath").password(bCryptPasswordEncoder().encode("Bharath@2310")).authorities("read").build();
//		userDetailsService.createUser(user);
//		return userDetailsService;
//		
//	}
	
//	@Bean
//	BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return  new BCryptPasswordEncoder();
//	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//since we are using basic authentication it enables basic authentication filter
		// we can also enable custom filter which we want (MysecurityFillter class)
		http.httpBasic();
//		http.addFilterAfter(new MysecurityFillter(),BasicAuthenticationFilter.class );
		// SessionCreationPolicy.STATELESS : we need to authorize every request session id in cookies will not be stored
		http.sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Create session if needed
     .and()
		.authorizeHttpRequests().anyRequest().authenticated();
		return http.build();
		
	}

}
