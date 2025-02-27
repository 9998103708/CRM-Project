package com.CRM.Customer.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRM.Customer.Entity.User;
import com.CRM.Customer.Service.AuthService;

@RestController
	@RequestMapping("/auth")
	public class AuthController {

	    private final AuthService authService;

	    public AuthController(AuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping("/register")
	    public String register(@RequestBody User user) {
	        return authService.register(user);
	    }

	    @PostMapping("/login")
	    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
	        String token = authService.login(credentials.get("username"), credentials.get("password"));
	        return Map.of("token", token);
	    }
	}