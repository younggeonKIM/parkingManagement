package com.co.parking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.UserEntity;
import com.co.parking.model.UserDTO;
import com.co.parking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	private boolean loginCheckToken;
	
	private String userName;
	
	public boolean isLoginCheckToken() {
		return loginCheckToken;
	}


	public String getUserName() {
		return userName;
	}

	public String userLoginResult(String uid, String upwd) {
		
		Optional<UserEntity> s =ur.findById(uid);
		
		if(! s.isPresent()) {
			

			this.loginCheckToken = false;
			return "ID not found";
		} 
		else {
			
			if(upwd.equals(s.get().getUserPWD()) ) {
				
				this.loginCheckToken = true;
				this.userName = s.get().getUserName();
				return "login successful";
			}
			else {
				
				this.loginCheckToken = false;
				return "check your PWD is correct";
			}
		}
		
	}
}
