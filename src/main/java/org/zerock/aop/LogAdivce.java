package org.zerock.aop;



import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdivce {
	
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		
		log.info("=======================================================================");
	}
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String,String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		
		log.info("str1: " + str1);
		log.info("str2: " + str2);
	}
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))" , throwing="exception")
	public void logException(Exception exception){
		
		log.info("Exception.....!!!!");
		log.info("exception: " + exception);
	}
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime( ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		
		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generted catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
									// 1000이 1초를 의미함
		log.info("프로그램 실행시간 " + (end - start)/1000.0 + "초");
		return result;
		
	}
}