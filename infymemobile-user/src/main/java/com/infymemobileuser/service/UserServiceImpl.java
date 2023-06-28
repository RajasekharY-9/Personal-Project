package com.infymemobileuser.service;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infymemobileuser.dto.LoginDTO;
import com.infymemobileuser.dto.UserDTO;
import com.infymemobileuser.entity.Login;
import com.infymemobileuser.entity.UserEntity;
import com.infymemobileuser.repository.LoginRepository;
import com.infymemobileuser.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginRepository loginRepository;

	public static final Log logger = LogFactory.getLog(UserService.class);

	@Override
	public String createUser(UserDTO userDTO) throws InfyMeMobileException {
		// TODO Auto-generated method stub
     String userId=userDTO.getUserId();
     Optional<UserEntity> existUser = userRepository.findByUserId(userId);
		if (existUser.isPresent()) {
			throw new InfyMeMobileException("User with User Id Already Present");
		}
		
		UserEntity user = new UserEntity();
		user.setAccountHolderName(userDTO.getAccountHolderName());
		user.setCommunicationAddress(userDTO.getCommunicationAddress());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setEmail(userDTO.getEmail());
		user.setGender(userDTO.getGender());
		user.setMobileNumber(userDTO.getMobileNumber());
		user.setPAN(userDTO.getPAN());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserId());
		

		UserEntity saved = userRepository.save(user);
         System.out.println("exception in create user");
		return ""+saved.getMobileNumber();
	}

	@Override
	public boolean loginUser(LoginDTO loginDTO) throws InfyMeMobileException {
		// TODO Auto-generated method stub
		
		Long mobileNumber=loginDTO.getMobileNumber();
		  Optional<UserEntity> existUser = userRepository.findById(mobileNumber);
		if(existUser.isPresent()) {
			UserEntity us=existUser.get();
			String password=loginDTO.getPassword();
			String storedpass=us.getPassword();
			if(password.equals(storedpass)) {
				return true;
			}
		}
		throw new InfyMeMobileException("Authentication Failed.");
		
		
	}
	

	@Override
	public UserDTO getUserProfile(String userId) throws InfyMeMobileException {

		Optional<UserEntity> os = userRepository.findByUserId(userId);
		if (os.isPresent()) {
			UserEntity usentity=os.get();
			UserDTO us = new UserDTO();
			us.setUserId(usentity.getUserId());
			us.setAccountHolderName(usentity.getAccountHolderName());
			us.setCommunicationAddress(usentity.getCommunicationAddress());
			us.setDateOfBirth(usentity.getDateOfBirth());
			us.setEmail(usentity.getEmail());
			us.setGender(usentity.getGender());
			us.setMobileNumber(usentity.getMobileNumber());
			us.setPAN(usentity.getPAN());
			us.setPassword(usentity.getPassword());
			
			return us;
			
		} else {
			throw new InfyMeMobileException("USERID_NOT_FOUND");
		}

	
	}

	@Override
	public List<UserDTO> showAllUsers() throws InfyMeMobileException {
     //System.out.println("Show all users");
		
		List<UserEntity> ue = userRepository.findAll();

		logger.debug("finding all ");
		List<UserDTO> list = new ArrayList<>();
		ue.forEach(c -> {
			UserDTO c2 = new UserDTO();
			c2.setAccountHolderName(c.getAccountHolderName());
			c2.setCommunicationAddress(c.getCommunicationAddress());
			c2.setDateOfBirth(c.getDateOfBirth());
			c2.setEmail(c.getEmail());
			c2.setGender(c.getGender());
			c2.setMobileNumber(c.getMobileNumber());
			c2.setPAN(c.getPAN());
			c2.setPassword(c.getPassword());
			c2.setUserId(c.getUserId());
			list.add(c2);
			logger.debug("adding all");
		});
		if (list.isEmpty()) {
			logger.debug("Exception in show all");
			throw new InfyMeMobileException("NO_USERS_FOUND");
			
		}
		logger.debug("return all users");
		return list;
		
	}

}
