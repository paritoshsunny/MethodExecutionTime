package com.methodExecution.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

	Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

	@Around("@annotation(com.methodExecution.advice.MethodExecutionTimeLogger)")
	public Object TimeTracker(ProceedingJoinPoint pjp) throws Throwable {

		long startTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long endTime = System.currentTimeMillis();
		long actualTime = endTime - startTime;
		if (actualTime > 200) {
			logger.info("Method Name : " + pjp.getSignature() + " Execution Time : " + actualTime);
		}

		return obj;
	}

}
