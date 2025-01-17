package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.service.CustomerDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	@Autowired
	private CustomerDetailsService customerservice;
	@Autowired
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
public AuthenticationProvider authprovider() {
	DaoAuthenticationProvider provider=  new DaoAuthenticationProvider();
	provider.setUserDetailsService(customerservice);
	provider.setPasswordEncoder(pwdEncoder());
	return provider;
}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
    @Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()
                .and().authorizeHttpRequests().requestMatchers("/api/**").authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                authenticationProvider(authprovider())
                //addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);)
                .build();
	}

}
