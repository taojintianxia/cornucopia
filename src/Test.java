import java.util.Random;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Aug 28, 2013 11:10:31 AM
 * 
 */
public class Test {

	static Random random = new Random();

	public static void main(String... args) {
		long start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			String str = random.nextBoolean() + "";
			if (str.equals("true")) {
			} else if (str.equals("false")) {
			}
		}

		System.out.println("it takes : " + (System.nanoTime() - start));

		start = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			String str = random.nextBoolean() + "";
			switch (str) {
			case "true":
				break;
			case "false":
				break;
			}
		}

		System.out.println("it takes : " + (System.nanoTime() - start));

	}
}
