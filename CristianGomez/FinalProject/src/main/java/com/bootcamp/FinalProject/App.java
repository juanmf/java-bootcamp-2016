package com.bootcamp.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bootcamp.FinalProject.entity.User;
import com.bootcamp.FinalProject.repository.UserRepository;

/**
 * Class that runs the Spring Boot application.
 * 
 * @author Cadrian
 *
 */
@ComponentScan("com.bootcamp.FinalProject")
@SpringBootApplication
public class App {
  //http://localhost:8080/swagger-ui.html (api-info)
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	     
	    @Bean
	    CommandLineRunner init(final UserRepository userRepository) {
	
	        return new CommandLineRunner() {
	
	            @Override
	            public void run(String... arg0) throws Exception {
	                userRepository.save(new User("Cadrian", "pass"));
	                userRepository.save(new User("Admin", "Admin"));	                
	            }
	
	        };
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
	                User user = userRepository.findByUsername(username);
	                if (user != null) {
	                    return new  org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true,true, 
	                            AuthorityUtils.createAuthorityList("USER"));
	                } else {
	                    throw new UsernameNotFoundException("could not find the user '"
	                            + username + "'");
	                }
	            }
	
	       };
	    }
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests().anyRequest().fullyAuthenticated().and().
	                httpBasic().and().
	                csrf().disable();
	    }
}
