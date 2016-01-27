package spring.aop;

import org.aspectj.lang.annotation.Before;

public class LoggingAspect {
	@Before("execution(public int spring.aop.impl.ArithmeticCalculatorImpl.add(int , int ))")
	 public void beforeMethod() {
		 System.out.println("add方法执行之前打印出来");
	}
}
