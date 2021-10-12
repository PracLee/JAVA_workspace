package com.lee.app.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class BeforeAdvice {
	
	@Before("PointCut.aPointcut()")
	public void beforeLog() {
		System.out.println("select*() �������� ����Ǵ� �޼ҵ�!");
	}
}
