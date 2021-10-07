package com.lee.app.common;

import org.aspectj.lang.JoinPoint;

public class AfterAdvice {
	public void printLog(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String name = jp.getSignature().getName();
		System.out.println("�޼ҵ�� : "+name);
		System.out.println("�Ű� ���� ���� : "+args);
		System.out.println("�ٽɰ���(��������Ʈ) �Ŀ� ȣ���!");
	}
}
