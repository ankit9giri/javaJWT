package com.fivegdimension.api.config;


import org.apache.catalina.filters.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fivegdimension.api.controller.AuthController;
import com.fivegdimension.api.filter.JWTFilter;
import com.fivegdimension.api.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	CustomUserDetailService userservice;

	@Autowired
	private JWTFilter jwtFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("userDetailsService ************** ");
		auth.userDetailsService(userservice);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("sercurity config * ");
		http.cors().disable();
		http.csrf().disable().authorizeRequests().antMatchers("/api/authenticate").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/*").antMatchers("/app/*/*.{js,html}")
//				.antMatchers("/bower_components/**").antMatchers("/i18n/**").antMatchers("/content/**")
//				.antMatchers("/swagger-ui/index.html").antMatchers("/test/**");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().and().formLogin().loginProcessingUrl("/api/authenticate").usernameParameter("username")
//				.passwordParameter("password").permitAll().and().logout().logoutUrl("/api/logout").permitAll().and()
//				.headers().frameOptions().disable().and().authorizeRequests().antMatchers("/api/hello").permitAll()
//				.antMatchers("/api/authenticate").permitAll().antMatchers("/api/**").authenticated().and()
//				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// 
//		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	}

}