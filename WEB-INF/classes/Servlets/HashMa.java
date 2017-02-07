package Servlets;

import java.util.HashMap;
import java.util.Map;

public class HashMa {

	private static Map<String, String> hm = new HashMap<String, String>();

	public static Map<String, String> getHm() {
		return hm;
	}

	public static void setHm(Map<String, String> hm) {
		HashMa.hm = hm;
	}
}
