package validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.co.parking.model.UserDTO;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserDTO udto = (UserDTO)target;
		if(! StringUtils.hasLength(udto.getUserID())) {
			
			errors.rejectValue("userID", "ID를 반드시 입력해 주세요.");
		}
		
		if(! StringUtils.hasLength(udto.getUserPWD())) {
			
			errors.rejectValue("userPWD", "비밀번호를 반드시 입력해 주세요.");
		}
	}

	
}
