package spring.aop.impl;

import org.springframework.stereotype.Component;

import spring.aop.ArithmeticCalculator;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{
	public int add(int i, int j) {
		int result = i + j;
		return result;
	}

	public int sub(int i, int j) {
		int result = i - j;
		return result;
	}

	public int mul(int i, int j) {
		int result = i * j;
		return result;
	}

	public int div(int i, int j) {
		int result = i / j;
		return result;
	}

}
