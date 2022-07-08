package com.acldigital.unaito.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.acldigital.unaito.service.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class UnaitoSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers("/unaito/v1/users/sign-in", "/static/**",  "/unaito/v1/users/register",
						"/unaito/v1/users/edit", "/unaito/v1/users/delete/*",
						"/unaito/v1/users/forgot-password/email/*", "http://localhost:8080/login",
						"/unaito/v1/projects/create",
						"/unaito/v1/projects/*/team-onboarding/add-team-member","/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()// .formLogin().loginPage("/unaito/v1/users/sign-in").and()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
				.accessDeniedPage("/" + HttpStatus.UNAUTHORIZED);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v1/api-docs").antMatchers("/swagger-resources/**").antMatchers("/swagger-ui.html")
				.antMatchers("/swagger-ui/**").antMatchers("/actuator/**").and().ignoring()
				.antMatchers("h2-console/**/**");
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean()throws Exception{
		return super.authenticationManagerBean();
	}
}