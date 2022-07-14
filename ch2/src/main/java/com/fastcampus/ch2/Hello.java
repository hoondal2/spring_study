package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출 가능한 프로그램으로 등록
@Controller
public class Hello {
	
	int iv = 10;
	static int cv = 20;
	
	//2. url과 메서드 연결
	@RequestMapping("/hello")
	public void main() { // 인스턴스 메서드 => iv, cv를 둘 다 사용 가능
		// static이 없는데 어떻게 호출? -> 인스턴스 메서드는 객체 생성을 해야함, 그렇다면 어디선가 객체를 생성했다는 것 
		//-> url로원격 프로그램을 호출하면, 톰캣에서 객체 생성, 그 후에 메서드 호출
		System.out.println("hello");
		System.out.println(cv);  // ok
		System.out.println(iv);  // ok
		
		// => 두개 다 사용 가능한 인스턴스 메서드가 유용하다
		// private으로 해도 된다 => 외부 호출이 어떻게 가능? 
		// ==> Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능제공 
		// java.lang.reflect 패키지를 제공 

	}
	
	public static void main2() { // static 메서드 => cv만 사용 가능
		System.out.println(cv);  // ok
		
		
	}

}