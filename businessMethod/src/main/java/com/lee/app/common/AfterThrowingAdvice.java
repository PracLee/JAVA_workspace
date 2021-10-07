package com.lee.app.common;

import org.aspectj.lang.JoinPoint;


public class AfterThrowingAdvice {
	public void printLog(JoinPoint jp, Exception e) {
		String name = jp.getSignature().getName();
		System.err.println("�޼ҵ�� : "+name);
		if(e instanceof IllegalAccessException) {
			System.out.println("�Ű������� �������� �ʽ��ϴ�!");
			System.out.println("Ȯ�λ��� 1. �� �ϼ���");
			System.out.println("Ȯ�λ��� 2. ���� Ȯ�� �ϼ���");
		}else {
			System.out.println("��Ȯ�� �����Դϴ�!");			
		}
		System.out.println("���ܹ߻��� ȣ����");
	}
}
