package com.grupowl.desafio_unidac.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		
		 auth.userDetailsService(userDetailsService);

		 auth.inMemoryAuthentication()
			.withUser("root")
			.password("root")
			.authorities("ROLE_USER");

	}
	
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		

		http.authorizeRequests()
			.antMatchers("/funcionario").permitAll()
			.antMatchers("/funcionario/all").permitAll()
			.antMatchers("/funcionario/{id}").permitAll()
			.antMatchers("/opcoes").permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().cors()
			.and().csrf().disable();
			
	}
}
