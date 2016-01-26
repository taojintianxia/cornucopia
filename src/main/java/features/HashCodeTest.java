package features;

import java.util.HashMap;

public class HashCodeTest {

	class Apple {
		private String color;

		public Apple(String color) {
			this.color = color;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Apple))
				return false;
			if (obj == this)
				return true;
			return this.color == ((Apple) obj).color;
		}

		public int hashCode() {
			return new String(this.color).hashCode();
		}
	}

	public static void main(String[] args) {
		HashCodeTest hashTest = new HashCodeTest();
		HashCodeTest.Apple a1 = hashTest.new Apple("green");
		HashCodeTest.Apple a2 = hashTest.new Apple("red");

		// hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		// if we remove the overwrite hashCode method , we will get nothing but
		// just a null here
		System.out.println(m.get(hashTest.new Apple("green")));
	}

}