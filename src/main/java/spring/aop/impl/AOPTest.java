package spring.aop.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.ArithmeticCalculator;

public class AOPTest {

	@Test
	public void testAOP() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springApplicationContext.xml");
		ArithmeticCalculator arithmeticCalculator = applicationContext.getBean(ArithmeticCalculator.class);
		int result = arithmeticCalculator.add(3, 9);
		System.out.println("result = " + result);
	}
}
