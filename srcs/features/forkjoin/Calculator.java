package features.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Jan 7, 2014 4:41:41 PM
 * 
 */

public class Calculator extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 2983598301924904899L;
	private static final int THRESHOLD = 2000;
	private int start;
	private int end;

	public Calculator(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		if ((start - end) < THRESHOLD) {
			for (int i = start; i < end; i++) {
				sum += i;
			}
		} else {
			int middle = (start + end) / 2;
			Calculator left = new Calculator(start, middle);
			Calculator right = new Calculator(middle + 1, end);
			left.fork();
			right.fork();

			sum = left.join() + right.join();
		}
		return sum;
	}

	public Integer normalSum() {
		int sum = 0;
		for (int i = 0; i < end; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String... args) throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		Calculator cal = new Calculator(0, Integer.MAX_VALUE);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> result = forkJoinPool.submit(cal);
		System.out.println(result.get());
		System.out.println("it takes : " + (System.currentTimeMillis() - start) + "mill seconds");
		start = System.currentTimeMillis();
		System.out.println(cal.normalSum());
		System.out.println("it takes : " + (System.currentTimeMillis() - start) + "mill seconds");
	}

}
