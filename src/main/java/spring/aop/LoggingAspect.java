package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	public void beforeMethod() {
		System.out.println("方法执行之前打印出来");
	}

	public void afterMethod() {
		System.out.println("方法执行之后打印出来");
	}

	public void afterThrowing() {
		System.out.println("Throw方法执行之后打印出来");
	}

	public void afterFinally() {
		System.out.println("Finally方法执行之后打印出来");
	}
	
	public int around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕方法打印开始");
		int result = (int) pjp.proceed();
		System.out.println("环绕方法打印结束");
		return result;
	}
}
