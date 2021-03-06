package com.lee.app.common;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception e) {
		String name = jp.getSignature().getName();
		System.err.println("메소드명 : "+name);
		if(e instanceof IllegalAccessException) {
			System.out.println("매개변수로 적절하지 않습니다!");
			System.out.println("확인사항 1. 뭐 하세요");
			System.out.println("확인사항 2. 여기 확인 하세요");
		}else {
			System.out.println("미확인 예외입니다!");			
		}
		System.out.println("예외발생시 호춯됨");
	}
}
