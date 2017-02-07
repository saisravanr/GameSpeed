package Servlets;

import java.util.HashMap;
import java.util.Map;

public class HashMaSt {

	private static Map<String, String> hmst = new HashMap<String, String>();

	public static Map<String, String> getHmst() {
		return hmst;
	}

	public static void setHmst(Map<String, String> hmst) {
		HashMaSt.hmst = hmst;
	}

}
