package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}
	
	@Before("allGetter()")
	public void SecondAdvice() {
		System.out.println("Second Advice");
		
	}
	
	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetter() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}
	// After Annotation
	@After("allGetter()")
	public void AfterGetter() {
		System.out.println("AFTER all Getters");
	}

	// AfterReturning
	@AfterReturning(pointcut="execution( public * *(..))", returning = "retVal")
	public void afterReturning(JoinPoint joinPoint, Object retVal) {
		System.out.println("Method Invoked after Returning");
		
		//System.out.println("Method Class Name "  + joinPoint.getClass());
		//System.out.println("Method has Arguments "  + joinPoint.getArgs());
		System.out.println("Method Signature Name"  + joinPoint.getSignature());
	}

	// AroundAnnotation
	@Pointcut("execution (public * set*(..))")
	private void allSet() {}


	@Around("allSet()")
	public void aroundAdvice() {
		System.out.println("Print before and after Setter");
	}


	// AfterThrowing
	@AfterThrowing(pointcut ="execution( public * *(..))",throwing="error")
	public void afterThrowingAdvice() {
		System.out.println("Exception Occured");
	}

}
