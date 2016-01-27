package spring.aop;

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
}
