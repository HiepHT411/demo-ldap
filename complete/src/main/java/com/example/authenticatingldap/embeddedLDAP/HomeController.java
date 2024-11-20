package com.example.authenticatingldap.embeddedLDAP;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "Welcome to the home page!";
	}

//	public static void main(String[] args) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String hashedPassword = encoder.encode("password");
//		System.out.println(hashedPassword);
//
//		System.out.println(encoder.matches("password", "$2a$10$75vnaGgWBDFjN0Kbh1HNfOw12ACIypwk61FqJlImI61QxCqiWaP6a"));
//	}
}
