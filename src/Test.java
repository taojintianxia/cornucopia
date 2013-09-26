import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * 
 * 
 * @author Kane.Sun
 * @version Aug 28, 2013 11:10:31 AM
 * 
 */
public class Test {

	private static Random random = new Random();

	public static void main(String... args) throws Exception {
		for(int i = 0 ; i < 3;i++){
			if(i==2)
				continue;
			System.out.println("------");
		}
	}

	public static void getMaxmiumSubSum(int[] targetArray) {
		int length = targetArray.length;
		int[] minusArray = new int[length - 1];
		for (int i = 0; i < length - 2; i++) {
			minusArray[i] = targetArray[i] - targetArray[i + 1];
		}
		int sum = 0;
		int preIndex = 0;
		int nextIndex = 0;
		int max = 0;

		for (int i = 0; i < length - 2; i++) {
			sum += minusArray[i];
			if (sum > 0) {
				sum = 0;
			} else {
				if (sum == minusArray[i]) {
					preIndex = i;
				}
			}

			if (max > sum) {
				max = sum;
				nextIndex = i;
			}
		}

		System.out.println("first Number : " + targetArray[preIndex]);
		System.out.println("second Number : " + targetArray[nextIndex + 1]);
	}
}
