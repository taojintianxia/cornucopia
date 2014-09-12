package pattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Kane.Sun
 * @version Jun 10, 2014 1:55:11 PM
 * 
 */
@SuppressWarnings("unused")
public class IfElseRefactory {

	public static void main(String... args) throws Exception {
		IfElseRefactory ifElseRefactory = new IfElseRefactory();
		basicSolution("A");
		enumSolution("D");
		dynamicInvokeSolution("B", ifElseRefactory);
		new IfElseRefactory().new ChainofResponsibilityMutation().invokeHandler("C");
	}

	public static void basicSolution(String targetStr) {
		if (targetStr.equals("A")) {
			System.out.println(targetStr + " is printing ");
		} else if (targetStr.equals("B")) {
			System.out.println(targetStr + " is printing ");
		} else if (targetStr.equals("C")) {
			System.out.println(targetStr + " is printing ");
		} else if (targetStr.equals("D")) {
			System.out.println(targetStr + " is printing ");
		} else {
			System.out.println("Other" + " is printing ");
		}
	}

	public static void enumSolution(String str) {
		StrEnum.getInstance(str).handleStr();
	}

	private enum StrEnum {

		StrA("A") {
			@Override
			public void handleStr() {
				System.out.println(getStr() + " is printing ");
			}
		},
		StrB("B") {
			@Override
			public void handleStr() {
				System.out.println(getStr() + " is printing ");
			}
		},
		StrC("C") {
			@Override
			public void handleStr() {
				System.out.println(getStr() + " is printing ");
			}
		},
		StrD("D") {
			@Override
			public void handleStr() {
				System.out.println(getStr() + " is printing ");
			}
		},
		Other("Other") {
			@Override
			public void handleStr() {
				System.out.println(getStr() + " is printing ");
			}
		};

		private String str;

		public String getStr() {
			return this.str;
		}

		public abstract void handleStr();

		private StrEnum(String str) {
			this.str = str;
		}

		public static StrEnum getInstance(String str) {
			for (StrEnum strEnum : StrEnum.values()) {
				if (strEnum.str.equals(str)) {
					return strEnum;
				}
			}
			return Other;
		}
	}

	public static void dynamicInvokeSolution(String str, IfElseRefactory ifElseRefactory) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Map<String, Method> testMap = new HashMap<>();
		testMap.put("A", IfElseRefactory.class.getDeclaredMethod("handleA"));
		testMap.put("B", IfElseRefactory.class.getDeclaredMethod("handleB"));
		testMap.put("C", IfElseRefactory.class.getDeclaredMethod("handleC"));
		testMap.put("D", IfElseRefactory.class.getDeclaredMethod("handleD"));
		testMap.put("Other", IfElseRefactory.class.getDeclaredMethod("handleOther"));
		testMap.get(str).invoke(ifElseRefactory);
	}

	private class ChainofResponsibilityMutation {
		public void methodA(String param) {
			if (param.equals("A")) {
				System.out.println("A is printing");
				;
			} else {
				methodB(param);
			}
		}

		public void methodB(String param) {
			if (param.equals("B")) {
				System.out.println("B is printing");
			} else {
				methodC(param);
			}
		}

		public void methodC(String param) {
			if (param.equals("C")) {
				System.out.println("C is printing");
			} else {
				methodD(param);
			}
		}

		public void methodD(String param) {
			if (param.equals("D")) {
				System.out.println("D is printing");
			} else {
				System.out.println("there is no method to handle this request");
			}
		}

		public void invokeHandler(String param) {
			methodA(param);
		}
	}

	private void handleA() {
		System.out.println("A is printing ");
	}

	private void handleB() {

		System.out.println("B is printing ");
	}

	private void handleC() {
		System.out.println("C is printing ");
	}

	private void handleD() {
		System.out.println("D is printing ");
	}

	private void handleOther() {
		System.out.println("Other is printing ");
	}
}
