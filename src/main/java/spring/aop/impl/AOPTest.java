package spring.aop.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.ArithmeticCalculator;

public class AOPTest {

	private ApplicationContext applicationContext;

	@Test
	public void testAOP() {
		applicationContext = new ClassPathXmlApplicationContext("springApplicationContext.xml");
		ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);
		int result = arithmeticCalculator.add(3, 9);
		System.out.println("add result = " + result);

		result = arithmeticCalculator.sub(1, 1);
		System.out.println("sub result = " + result);

		try {
			result = arithmeticCalculator.div(1, 0);
			System.out.println("div result = " + result);
		} catch (Exception e) {
			System.out.println("in catch clause");
		} finally {
			System.out.println("in finally");
		}

		result = arithmeticCalculator.mul(2, 3);
		System.out.println("mul result = " + result);

	}
}
