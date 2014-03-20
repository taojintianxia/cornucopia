package trick;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Dec 9, 2013 3:09:15 PM
 * 
 */

public class RunningMethodNameRetriever {

	public static void main(String... args) {
		RunningMethodNameRetriever test = new RunningMethodNameRetriever();
		test.getCurrentExecutingMethodName1();
		test.getCurrentExecutingMethodName2();
	}

	public void getCurrentExecutingMethodName1() {

		try {
			throw new Throwable() {
				private static final long serialVersionUID = -5221391601169419608L;
			};
		} catch (Throwable e) {
			System.out.println("what's the current method : " + e.getStackTrace()[0].getMethodName());
		}
	}

	public void getCurrentExecutingMethodName2() {
		System.out.println("what's the current method : " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

}
