package com.infymemobileuser.controller;

import java.util.List;


import javax.validation.Valid;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infymemobileuser.dto.LoginDTO;
import com.infymemobileuser.dto.UserDTO;
import com.infymemobileuser.service.InfyMeMobileException;
import com.infymemobileuser.service.UserService;

@RestController
@CrossOrigin
@Validated
public class UserApi {

	@Autowired
	private UserService userService;
	public static final Log LOGGER = LogFactory.getLog(UserApi.class);
	
	@Autowired
	private Environment environment;
	/*
	 * @Autowired private RestTemplate template;
	 */

	//http://localhost:8081/users
	@PostMapping(value = "/users")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) throws InfyMeMobileException {
 
		
		
		return new ResponseEntity<>(userService.createUser(userDTO),HttpStatus.CREATED);

	}

	//http://localhost:8081/users/login
	@PostMapping(value = "users/login")
	public ResponseEntity<Boolean> loginUser(@Valid @RequestBody LoginDTO loginDTO) throws InfyMeMobileException {

		return new ResponseEntity<>(userService.loginUser(loginDTO),HttpStatus.CREATED);

	}

	//http://localhost:8081/users/U93453
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId) throws InfyMeMobileException {
		return new ResponseEntity<>(userService.getUserProfile(userId),HttpStatus.OK);

	}

	//http://localhost:8081/users/all
	@GetMapping("/users/all")
	public ResponseEntity<List<UserDTO>> showAllUsers() throws InfyMeMobileException {
		List<UserDTO> us=userService.showAllUsers();
		return new ResponseEntity<>(us,HttpStatus.OK);

	}
	  @ExceptionHandler(InfyMeMobileException.class)
	    public ResponseEntity<String> handleInfyMeMobileException(InfyMeMobileException ex) {
	        LOGGER.error("InfyMeMobileException occurred: " + ex.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	    }

}
