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

	public static void main(String... args) {
		String str = "万业企业 600641";
		System.out.println(str.substring(str.lastIndexOf(" ") + 1));
		System.out.println(str.substring(0,str.lastIndexOf(" ")));
	}

}
