import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
		// 1+2+3+4=10
		List<Integer> tmpList = new ArrayList<>();
		tmpList.add(1);
		tmpList.add(1);
		tmpList.add(1);
		tmpList.add(1);
		int target = 0;
		boolean solutionFound = false;
		List<String> symList = new ArrayList<>(tmpList.size() - 1);
		for (int i = 0; i < (int) Math.pow(2, tmpList.size() - 1) - 1; i++) {
			int temp = tmpList.get(0);
			translateSymbol(i, symList, tmpList.size() - 1);
			for (int j = 0; j < symList.size(); j++) {
				if (symList.get(j) == "+") {
					temp += tmpList.get(j + 1);
				} else {
					temp -= tmpList.get(j + 1);
				}
			}
			if (temp == target) {
				for (int x = 0; x < tmpList.size(); x++) {
					if (x == symList.size()) {
						System.out.print(tmpList.get(x) + "=" + target);
						break;
					} else {
						System.out.print(tmpList.get(x) + symList.get(x));
					}
				}
				solutionFound = true;
				System.out.println();
			}
		}

		if (tmpList.size() == 2 && checkForOneMinus(tmpList, target)) {
			System.out.print(tmpList.get(0) + "-" + tmpList.get(1) + "=" + target);
		}

		if (!solutionFound && !checkForOneMinus(tmpList, target)) {
			System.out.println("No Solution");
		}
	}

	private static void translateSymbol(int num, List<String> targetList, int size) {
		targetList.clear();
		int max = size;
		BigInteger src = new BigInteger(num + "");
		String completeBinaryNumber = src.toString(2);
		while (completeBinaryNumber.length() < max) {
			completeBinaryNumber = "0" + completeBinaryNumber;
		}

		for (int i = 0; i < completeBinaryNumber.length(); i++) {
			if (completeBinaryNumber.charAt(i) == '0') {
				targetList.add("+");
			} else {
				targetList.add("-");
			}
		}

	}

	private static boolean checkForOneMinus(List<Integer> targetList, int targetNumber) {
		if ((targetList.get(0) - targetList.get(1)) == targetNumber) {
			return true;
		}
		return false;
	}

}
