import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
		try {
			URL cumtURL = new URL("http://www.google.com/finance?q=600016");
			URLConnection cumtConnection = cumtURL.openConnection();
			DataInputStream din = new DataInputStream(cumtConnection.getInputStream());
			String inputLine;
			while ((inputLine = din.readLine()) != null) {
				System.out.println(inputLine);
			}
			din.close();
		} catch (MalformedURLException me) {
		} catch (IOException ioe) {
		}
	}

}
