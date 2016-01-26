package trick;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimerForMethodDelayB {

	private final Random random = new Random();

	public static void main(String... args) {
		TimerForMethodDelayB test = new TimerForMethodDelayB();
		System.out.println("the result is : " + test.getRusultFromSumulationMethod());
	}

	public Integer methodSimulation() {
		try {
			int workingTime = random.nextInt(5) + 1;
			SECONDS.sleep(workingTime);
			System.out.println("Simulation Method takes " + workingTime + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 50;
	}

	public Integer getRusultFromSumulationMethod() {
		Integer value = 0;
		final ExecutorService exec = Executors.newFixedThreadPool(1);
		Callable<Integer> call = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return Integer.valueOf(methodSimulation());
			}
		};

		try {
			Future<Integer> future = exec.submit(call);
			value = future.get(3, TimeUnit.SECONDS);
			System.out.println("target value is " + value);
		} catch (TimeoutException ex) {
			System.out.println("task time out , return the default value");
			value = 10;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		// close thread pool
		exec.shutdown();

		return value;
	}

}
