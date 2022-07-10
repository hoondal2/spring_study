package com.fastcampus.ch2;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
//==================== servlet-context.xml에서 처리 (view-controller) =====================//
@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	//@GetMapping("/register/add") // 신규회원 가입 화면
	public String register() {
		return "registerForm";	
	}
//=======================================================================================//

	
	//@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save") // post방식으로만 회원 가입 가능
	public String save(User user, Model m) throws UnsupportedEncodingException {
	
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
			return "forward:/register/add";
			//return "redirect:/register/add?msg=" +msg; // url 재작성(rewriting)
		}

		// 2. DB에 신규회원 정보를 저장
		return "registerInfo";
		
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
