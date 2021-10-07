package com.lee.app.common;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception e) {
		String name = jp.getSignature().getName();
		System.err.println("¸Ş¼Òµå¸í : "+name);
		if(e instanceof IllegalAccessException) {
			System.out.println("¸Å°³º¯¼ö·Î ÀûÀıÇÏÁö ¾Ê½À´Ï´Ù!");
			System.out.println("È®ÀÎ»çÇ× 1. ¹¹ ÇÏ¼¼¿ä");
			System.out.println("È®ÀÎ»çÇ× 2. ¿©±â È®ÀÎ ÇÏ¼¼¿ä");
		}else {
			System.out.println("¹ÌÈ®ÀÎ ¿¹¿ÜÀÔ´Ï´Ù!");			
		}
		System.out.println("¿¹¿Ü¹ß»ı½Ã È£­ŒµÊ");
	}
}
