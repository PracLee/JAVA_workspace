package com.lee.app.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import model.member.MemberVO;

@Service
@Aspect
public class AterReturningAdvice {
	@AfterReturning(pointcut="PointcutCommon.cPointcut()", returning="obj")
	public void printLog(JoinPoint jp,Object obj) {
		String name = jp.getSignature().getName();
		System.err.println("�޼ҵ�� : "+name);
		if(obj instanceof MemberVO) {	// �տ� �ִ� ��ü�� �ڿ��ִ� ��ü�� ĳ������ �� �� �ִ��� Ȯ���ϴ� �ڵ�! �ǹ����� �������� ���̱� ���� ���!
			MemberVO data = (MemberVO)obj;			
			if(data.getRole().equals("ADMIN")) {
				System.out.println("������ �α���");
			}else {
				System.out.println("�Ϲݻ���� �α���");
			}
		}
		System.out.println("get()�� ���յǾ� ȣ���!");
	}
}
