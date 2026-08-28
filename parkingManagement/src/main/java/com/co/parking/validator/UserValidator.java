package validator;

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
			
			errors.rejectValue("userID", "ID를 반드시 입력해 주세요.");
		}
		
		if(! StringUtils.hasLength(udto.getUserPWD())) {
			
			errors.rejectValue("userPWD", "비밀번호를 반드시 입력해 주세요.");
		}
		
		if(ur.existsById(udto.getUserID())) {
			
			errors.rejectValue("userId", "ID가 중복됐습니다.");
		}
		
		if(cr.existsById(udto.getUserCarNum())) {
			
			errors.rejectValue("userCarNum", "입력하신 차량 번호가 이미 가입돼 존재하는 차량번호입니다.");
		}
	}

	
}
