package Servlets;

import java.util.HashMap;
import java.util.Map;

public class HashMaSa {

	private static Map<String, String> hmsa = new HashMap<String, String>();

	public static Map<String, String> getHmsa() {
		return hmsa;
	}

	public static void setHmsa(Map<String, String> hmsa) {
		HashMaSa.hmsa = hmsa;
	}

}
