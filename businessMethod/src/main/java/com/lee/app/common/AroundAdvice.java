package com.lee.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("pjp���ڸ� ���� �޼ҵ� ���ο��� ����ϴ� ����-1");
		System.out.println("�޼ҵ�� : "+pjp.getSignature().getName());
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		System.out.println("�ҿ�ð� : "+sw.getTotalTimeMillis());
		System.out.println("pjp���ڸ� ���� �޼ҵ� ���ο��� ����ϴ� ����-2");
		return obj;
	}
}
