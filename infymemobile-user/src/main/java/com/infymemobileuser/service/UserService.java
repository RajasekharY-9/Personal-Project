package com.infymemobileuser.service;

import java.util.List;

import com.infymemobileuser.dto.LoginDTO;
import com.infymemobileuser.dto.UserDTO;

public interface UserService {

	public String createUser(UserDTO userDTO) throws InfyMeMobileException;
	
	public boolean loginUser(LoginDTO loginDTO) throws InfyMeMobileException;
	
	public UserDTO getUserProfile(String userId) throws InfyMeMobileException;

	public List<UserDTO> showAllUsers() throws InfyMeMobileException;
	
}
