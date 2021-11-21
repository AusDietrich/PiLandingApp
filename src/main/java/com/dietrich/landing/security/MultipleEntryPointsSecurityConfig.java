package com.dietrich.landing.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig {

	@Value("${uploaderName}")
	public String uploaderName;
	@Value("${deployerName}")
	public String deployerName;

	@Value("${uploaderPass}")
	public String uploaderPass;
	@Value("${deployerPass}")
	public String deployerPass;

	@Bean
	public UserDetailsService userDetailsService() throws Exception {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User
				.withUsername(uploaderName)
				.password(encoder().encode(uploaderPass))
				.roles("uppy").build());
		manager.createUser(User
				.withUsername(deployerName)
				.password(encoder().encode(deployerPass))
				.roles("deppy").build());
		return manager;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
