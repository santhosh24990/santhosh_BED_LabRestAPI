package com.gl.fest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure( AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("santhosh").password("welcome").roles("ADMIN"))
		.withUser(users.username("rahul").password("welcome").roles("USER"));
				
		
		}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET , "/students/list", "/students/showstudentform").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.POST, "/students/save").hasAnyRole("ADMIN","USER")
				.antMatchers(HttpMethod.PUT, "/students/update").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE , "/students/delete").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin()
				.and().cors().and().csrf().disable();
	} 
}
