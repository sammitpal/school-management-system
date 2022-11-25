package com.security.controller;

import java.security.Principal;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.security.exception.BadCredentials;
import com.security.exception.RegistrationException;
import com.security.model.ErrorResponse;
import com.security.model.TokenResponse;
import com.security.model.User;
import com.security.model.UserModel;
import com.security.repository.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController implements ErrorController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private TokenResponse tokenResponse;

	@Autowired
	private ErrorResponse errorResponse;

	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody UserModel userModel) throws Exception {
		log.info("Inside the authenticate");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userModel.getUsername(), userModel.getPassword()));
			String token = JWT.create().withSubject(userModel.getUsername())
					.withExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000 * 24 * 60))
					.sign(Algorithm.HMAC512("${tokensecret}"));

			tokenResponse.setToken(token);
			return new ResponseEntity<>(tokenResponse, HttpStatus.OK);
		} catch (BadCredentialsException e) {
			throw new BadCredentials(e.getMessage());
		}

	}

	@PostMapping("/register")
	public Map<String, String> save(@RequestBody User user) throws RegistrationException {
		log.info("Inside register");
		log.info("Username: " + user.getUsername());
		Map<String, String> map = new HashMap<>();

		if (user.getUsername() == null || user.getEmail() == null && user.getPassword() == null) {
			map.put("error", "PLease enter the credentials");
		} else {
			User userFound = userRepo.findByUsername(user.getUsername()).orElse(null);
			if (userFound != null) {
				throw new RegistrationException("User Exists");
			} else {
				user.setProfilestatus(false);
				user.setPassword(encoder.encode(user.getPassword()));
				userRepo.save(user);
				map.put("message", "User registration Successful!");
			}
		}
		return map;
	}

	@GetMapping("/profile")
	public ResponseEntity<?> profile(Principal principal) throws NullPointerException{
		User user = null;
		try {			
			user = userRepo.findByUsername(principal.getName()).orElse(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	@PutMapping("/updateprofile")
	public ResponseEntity<?> updateProfile(Principal principal){
		try {			
			User user = null;
			user = userRepo.findByUsername(principal.getName()).orElse(null);
			user.setProfilestatus(true);
			try {
				User userupdated = userRepo.save(user);
				return new ResponseEntity(userupdated,HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@GetMapping("/error")
	public ResponseEntity<?> errorResponse(HttpServletResponse response){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Unauthorized");
		errorResponse.setHttpStatus(HttpStatus.valueOf(response.getStatus()));
		errorResponse.setTimestamp(Instant.now().toString());
		return new ResponseEntity(errorResponse,HttpStatus.valueOf(response.getStatus()));
	}
}
