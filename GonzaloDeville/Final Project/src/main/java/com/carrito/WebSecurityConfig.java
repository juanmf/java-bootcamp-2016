package com.carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.carrito.entities.User;
import com.carrito.repositories.UserRepository;
import com.carrito.services.IUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	public WebSecurityConfig() {
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/user/register").permitAll()
				.antMatchers(HttpMethod.POST, "/**").authenticated().antMatchers(HttpMethod.PUT, "/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/**").authenticated().anyRequest().permitAll().and().httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserRepository userRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userRepository.findByUserName(username);
				if (user != null) {
					return new org.springframework.security.core.userdetails.User(user.getUserName(),
							user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
				} else {
					throw new UsernameNotFoundException("could not find the user '" + username + "'");
				}
			}

		};
	}

}
