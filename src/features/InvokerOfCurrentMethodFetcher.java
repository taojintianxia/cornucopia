package features;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 *
 * @author Kane.Sun
 * @version Jun 26, 2014 11:20:02 AM
 * 
 */

public class InvokerOfCurrentMethodFetcher {
	public static void main(String... args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		InvokerOfCurrentMethodFetcher testClass = new InvokerOfCurrentMethodFetcher();

		Map<Integer, Method> methodMap = new HashMap<>();
		methodMap.put(0, InvokerOfCurrentMethodFetcher.class.getDeclaredMethod("methodA"));
		methodMap.put(1, InvokerOfCurrentMethodFetcher.class.getDeclaredMethod("methodB"));
		methodMap.put(2, InvokerOfCurrentMethodFetcher.class.getDeclaredMethod("methodC"));

		for (int i = 0; i < 100; i++) {
			methodMap.get(ThreadLocalRandom.current().nextInt(3)).invoke(testClass);
		}

	}

	public void methodA() {
		// System.out.println("Method A is running");
		invokeTargetMethod();
	}

	public void methodB() {
		// System.out.println("Method B is running");
		invokeTargetMethod();
	}

	public void methodC() {
		// System.out.println("Method B is running");
		invokeTargetMethod();
	}

	public void invokeTargetMethod() {
		// System.out.println("The Test Method is running");

		Throwable ex = new Throwable();
		StackTraceElement[] stackElements = ex.getStackTrace();
		if (stackElements != null) {
			// export this to the log file
			System.out.println("TRACKING " + stackElements[1].getMethodName() + " is invoking this method");
		}
	}
}
