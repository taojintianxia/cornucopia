package performance;

import java.util.Random;

public class SwitchAndIfComparation {

	private Random ramdom = new Random();

	public static void main(String... args) {
		SwitchAndIfComparation comparationTest = new SwitchAndIfComparation();

		long switchStart = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			comparationTest.switchTest();
		}
		long switchEnd = System.nanoTime();

		long ifElsestart = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			comparationTest.testIfElse();
		}
		long ifElseEnd = System.nanoTime();

		System.out.println("Switch KeyWord takes " + (switchEnd - switchStart));
		System.out.println("If Else KeyWord takes " + (ifElseEnd - ifElsestart));
	}

	public void switchTest() {
		int i = ramdom.nextInt(3);
		switch (i) {
		case 0:
			System.out.println("0");
		case 1:
			System.out.println("1");
		case 2:
			System.out.println(2);
		}

	}

	public void testIfElse() {
		int i = ramdom.nextInt(3);
		if (i == 0) {
			System.out.println("0");
		} else if (i == 1) {
			System.out.println("1");
		} else if (i == 2) {
			System.out.println("2");
		}
	}
}
