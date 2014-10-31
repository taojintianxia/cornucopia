package trick;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/*
 * sometime we may invoked in this situation : there is a method execute for
 * long time even will be delayed over an expected time. here is my solution to
 * set a delay time for a method which takes a random time
 */

public class TimerForMethodDelayA {

	private final Random random = new Random();

	public static void main(String... args) {
		TimerForMethodDelayA test = new TimerForMethodDelayA();
		System.out.println("this is the value : " + test.executeB());
	}

	// simulate the real method , this method take a long time once in a while
	public int methodSimulation() {
		try {
			int workingTime = random.nextInt(5) + 1;
			SECONDS.sleep(workingTime);
			System.out.println("Simulation Method takes " + workingTime + " seconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 50;
	}

	public int executeB() {
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

}

class VarContainer {
	private volatile int targetVariable = 0;

	public int getTargetVariable() {
		return targetVariable;
	}

	public void setTargetVariable(int targetVariable) {
		this.targetVariable = targetVariable;
	}
}
