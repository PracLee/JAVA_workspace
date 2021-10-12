package com.lee.app.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class BeforeAdvice {
	
	@Before("PointCut.aPointcut()")
	public void beforeLog() {
		System.out.println("select*() 실행전에 수행되는 메소드!");
	}
}
