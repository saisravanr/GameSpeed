package Servlets;

import java.util.HashMap;
import java.util.Map;

public class HashADU {
	private static Map<String, String> adu = new HashMap<String, String>();

	public static Map<String, String> getAdu() {
		return adu;
	}

	public static void setAdu(Map<String, String> adu) {
		HashADU.adu = adu;
	}

}
