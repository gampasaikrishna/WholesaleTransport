package com.sai.WholesaleTransport.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAop {

	private static final Logger LOGGER=Logger.getRootLogger(); 
		
	
	/*THIS PICE OF CODE WILL EFFECT ALL THE CLASS AND METHODS LOGGER STATMENTS  */
	
	@Before(value="execution(* com.sai.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint)
	{
		LOGGER.info("Entered:"+joinPoint.getSignature().getName()+":"+joinPoint.getTarget().getClass());
	}
	
	@After(value="execution(* com.sai.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint)
	{
		LOGGER.info("Exit:"+joinPoint.getSignature().getName()+":"+joinPoint.getTarget().getClass());
	}
	
}
