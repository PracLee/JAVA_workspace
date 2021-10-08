package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
	
	@Before("PointcutCommon.aPointcut()")
	public void printLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		System.out.println("�޼ҵ�� : "+name);
		System.out.println("�Ű� ���� ���� : "+args);
		System.out.println("�ٽɰ���(��������Ʈ) �Ŀ� ȣ���!");
	}
}
