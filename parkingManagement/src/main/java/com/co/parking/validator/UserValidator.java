package com.co.parking.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.co.parking.model.UserDTO;
import com.co.parking.repository.CarRepository;
import com.co.parking.repository.UserRepository;

@Component
public class UserValidator implements Validator {

	private final UserRepository ur;
	
	private final CarRepository cr;
	
	
	
	public UserValidator(UserRepository ur, CarRepository cr) {
		super();
		this.ur = ur;
		this.cr = cr;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserDTO udto = (UserDTO)target;
		if(! StringUtils.hasLength(udto.getUserID())) {
			
			errors.rejectValue("userID", "noInputID");
		}
		
		if(! StringUtils.hasLength(udto.getUserPWD())) {
			
			errors.rejectValue("userPWD", "noInputPWD");
		}
		
		if(ur.existsById(udto.getUserID())) {
			
			errors.rejectValue("userID", "dupliID");
		}
		
		if(cr.existsById(udto.getUserCarNum())) {
			
			errors.rejectValue("userCarNum", "existsCarNum");
		}
	}

	
}
