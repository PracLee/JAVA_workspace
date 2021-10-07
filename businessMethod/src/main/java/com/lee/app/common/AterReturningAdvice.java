package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

import model.member.MemberVO;

public class AterReturningAdvice {
	public void printLog(JoinPoint jp,Object obj) {
		String name = jp.getSignature().getName();
		System.err.println("메소드명 : "+name);
		if(obj instanceof MemberVO) {	// 앞에 있는 객체가 뒤에있는 객체로 캐스팅을 할 수 있는지 확인하는 코드! 실무에서 안정성을 높이기 위해 사용!
			MemberVO data = (MemberVO)obj;			
			if(data.getRole().equals("ADMIN")) {
				System.out.println("관리자 로그인");
			}else {
				System.out.println("일반사용자 로그인");
			}
		}
		System.out.println("get()과 조합되어 호출됨!");
	}
}
