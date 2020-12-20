package com.dequiz.DeQuiz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DeQuizUserDetailsService userDetailsService;
//	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/QuizMaster/**").authenticated()
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/QuizMaster/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.logoutSuccessUrl("/index.html")
		.and()
		.csrf().disable()
		;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}