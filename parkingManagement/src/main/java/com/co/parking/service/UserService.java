package com.co.parking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.parking.entity.CarEntity;
import com.co.parking.entity.UserEntity;
import com.co.parking.model.UserDTO;
import com.co.parking.repository.CarRepository;
import com.co.parking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	@Autowired
	CarRepository cr;
	
	private boolean loginCheckToken;
	
	private String userName;
	
	private String userCarNum;
	
	public boolean isLoginCheckToken() {
		return loginCheckToken;
	}


	public String getUserName() {
		return userName;
	}
	
	

	public String getUserCarNum() {
		return userCarNum;
	}


	public UserDTO userLoginResult(String uid, String upwd) {
		
		Optional<UserEntity> s =ur.findById(uid);
		
		
		if(!s.isPresent()) {
			

			this.loginCheckToken = false;
			return null;
		} 
		else {
			
			if(upwd.equals(s.get().getUserPWD()) ) {
				
				this.loginCheckToken = true;
				UserDTO udto = new UserDTO(s.get().getUserID(), s.get().getUserPWD(), s.get().getUserName(),s.get().getUserCarNum(), s.get().isUserParkFlag());
				
				return udto;
			}
			else {
				
				this.loginCheckToken = false;
				return null;
			}
		}
		
	}
	
	
	public void createUser(UserDTO udto) {
		
		UserEntity ue = new UserEntity();
		
		if(! ur.existsById(udto.getUserID()) && !cr.existsById(udto.getUserCarNum()) ) {
			
			// userID와 car table의 carNum 이 중복되지 않는다면, 주차 중이 아닌 (parkFlag=1) 신규 유저의 등록을 실행.
			ue = new UserEntity(udto.getUserID(), udto.getUserPWD(), udto.getUserName(), udto.getUserCarNum(), true );
			ur.save(ue);
		}
	}
	
	public void doReserveUser(String uid) {
		
		UserEntity ue = new UserEntity();
		ue= ur.findById(uid).get();
		
		// 예약을 하면 유저 주차중 여부가 주차 중 (false, parkFlag=0) 으로 바뀜.
		ue.setUserParkFlag(false);
		ur.save(ue);
	}
	
	public void doCheckout(String uid) {
		
		if(ur.existsById(uid)) {
			
			UserEntity ue = ur.findById(uid).get();
			// 현재 로그인 중인 id가 해당 entity의 id와 일치하면 주차 중 여부를 주차 중 아님 (parkflag=1) 
			// 으로 변경.
			ue.setUserParkFlag(true);
			ur.save(ue);
		}
	}
}
