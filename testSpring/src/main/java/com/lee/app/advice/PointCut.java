package com.lee.app.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCut {
	@Pointcut("execution(* model..*Impl.*select*(..))")
	public void aPointcut() {}
	
	@Pointcut("execution(* model.board.*Impl.*(..))")
	public void bPointcut() {}
	
	@Pointcut("execution(* model.member.*Impl.*(..))")
	public void cPointcut() {}
	
}
