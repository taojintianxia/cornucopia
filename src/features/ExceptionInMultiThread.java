package features;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionInMultiThread {

	public static void main(String... args) {

		Thread testThread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("meant to throws exception");
				System.out.println(1 / 0);
			}
		});
		UncaughtExceptionHandler exceptionHandler = new ErrHandler();
		testThread.setUncaughtExceptionHandler(exceptionHandler);
		testThread.start();

	}
}

class ErrHandler implements UncaughtExceptionHandler {
	/**
	 * we could handle the exception here , e.g. log , close resources
	 */
	@Override
	public void uncaughtException(Thread a, Throwable e) {
		System.out.println("This is:" + a.getName() + ",Message:" + e.getMessage());
		e.printStackTrace();
		System.out.println("CLOSE ALL RESOURCES");
	}
}
