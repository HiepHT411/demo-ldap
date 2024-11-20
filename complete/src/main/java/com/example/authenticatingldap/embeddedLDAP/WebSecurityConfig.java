package com.example.authenticatingldap.embeddedLDAP;

import org.springframework.context.annotation.Configuration;


@Configuration
public class WebSecurityConfig {

	//embedded ldap config
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((authorize) -> authorize
//				.anyRequest().fullyAuthenticated()
//			)
//			.formLogin(Customizer.withDefaults());
//
//		return http.build();
//	}
//
//	//embedded ldap config
//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.ldapAuthentication()
//				.userDnPatterns("uid={0},ou=people")
//				.groupSearchBase("ou=groups")
//				.contextSource()
//					.url("ldap://localhost:8389/dc=springframework,dc=org")
//					.and()
//				.passwordCompare()
//					.passwordEncoder(new BCryptPasswordEncoder())
//					.passwordAttribute("userPassword");
//	}
}