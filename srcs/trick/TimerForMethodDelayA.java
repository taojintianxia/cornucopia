package trick;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*
 * sometime we may involved in this situation : there is a method execute for
 * long time even delayed over an expected time. here is my solution to set a
 * delay time for a method
 */

public class TimerForMethodDelayA {

	private final Random random = new Random();

	/**
	 * simulation method returns 50 , default value for delay returns 10 Plan B
	 * is the enhancement of Plan A since there is an await time method in latch
	 */
	public static void main(String... args) {
		TimerForMethodDelayA test = new TimerForMethodDelayA();
		System.out.println("this is the value : " + test.invokeTheSimulationMethodWithPlanB());
	}

	// simulate the real method , this method take a long time once in a while
	public int methodSimulation() {
		try {
			int workingTime = random.nextInt(10) + 1;
			SECONDS.sleep(workingTime);
			System.out.println("Simulation Method takes " + workingTime + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 50;
	}

	public int invokeTheSimulationMethodWithPlanA() {
		// set the default value
		int tmp = 10;

		final CountDownLatch latch = new CountDownLatch(2);
		final VarContainer tmpContainer = new VarContainer();
		tmpContainer.setTargetVariable(tmp);

		new Thread(new Runnable() {
			@Override
			public void run() {
				tmpContainer.setTargetVariable(methodSimulation());
				latch.countDown();
				latch.countDown();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// this is my patience , my underline , I can not suffer
					// through any more time
					SECONDS.sleep(2);
					latch.countDown();
					latch.countDown();
					System.out.println("time up , return the default value immediately");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return tmpContainer.getTargetVariable();
	}

	public int invokeTheSimulationMethodWithPlanB() {
		int tmp = 10;
		final CountDownLatch latch = new CountDownLatch(1);
		final VarContainer tmpContainer = new VarContainer();
		tmpContainer.setTargetVariable(tmp);

		new Thread(new Runnable() {
			@Override
			public void run() {
				tmpContainer.setTargetVariable(methodSimulation());
				// in case of exception comes out during call simulation method
				Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						try {
							SECONDS.sleep(3);
							// we could change the default value here
							tmpContainer.setTargetVariable(20);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				});

				latch.countDown();
			}
		}).start();

		try {
			latch.await(3, SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return tmpContainer.getTargetVariable();
	}

}

class VarContainer {
	private int targetVariable = 0;

	public int getTargetVariable() {
		return targetVariable;
	}

	public void setTargetVariable(int targetVariable) {
		this.targetVariable = targetVariable;
	}
}
