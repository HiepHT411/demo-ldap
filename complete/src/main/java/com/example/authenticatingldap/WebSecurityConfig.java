package com.example.authenticatingldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
public class WebSecurityConfig {

	//embedded ldap config
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().fullyAuthenticated()
			)
			.formLogin(Customizer.withDefaults());

		return http.build();
	}

	//embedded ldap config
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.userDnPatterns("uid={0},ou=people")
				.groupSearchBase("ou=groups")
				.contextSource()
					.url("ldap://localhost:8389/dc=springframework,dc=org")
					.and()
				.passwordCompare()
					.passwordEncoder(new BCryptPasswordEncoder())
					.passwordAttribute("userPassword");
	}

	//docker openldap server config
//	@Bean
//	public DefaultSpringSecurityContextSource contextSource() {
//		return new DefaultSpringSecurityContextSource("ldap://localhost:389/dc=hiephoang,dc=com");
//	}
//
//	//docker openldap server config
//	@Bean
//	public AuthenticationManager authenticationManager(HttpSecurity http, DefaultSpringSecurityContextSource contextSource) throws Exception {
//		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//
//		authBuilder.ldapAuthentication()
////				.userDnPatterns("uid={0},ou=users,dc=hiephoang,dc=com")
////				.userSearchBase("ou=users")
//				.userSearchBase("dc=hiephoang,dc=com")
//				.userSearchFilter("(uid={0})")
//				.contextSource(contextSource);
//
//		return authBuilder.build();
//	}
//
//
//
//	//docker openldap server config
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//				.authorizeHttpRequests(authorize -> authorize
//						.anyRequest().authenticated() // Secure all requests
//				)
//				.formLogin(Customizer.withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		// No-op encoder since OpenLDAP handles password hashing with {SSHA}
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

}

//@Configuration
//public class WebSecurityConfig {

//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		return http
//			.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin(Customizer.withDefaults())
//			.build();
//	}
//}
