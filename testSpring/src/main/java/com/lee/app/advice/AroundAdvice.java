package com.lee.app.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Aspect
@Service
public class AroundAdvice {
	
	@Around("PointCut.bPointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("시간측정 시작!");
		System.out.println("메소드명 : "+pjp.getSignature().getName());
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		System.out.println("소요시간 : "+sw.getTotalTimeMillis());
		System.out.println("시간측정 끝!");
		return obj;
	}
}
