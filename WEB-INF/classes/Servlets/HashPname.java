package Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashPname {
	private static Map<String, List<String>> pn = new HashMap<String, List<String>>();

	private static List<String> ln = new ArrayList<String>();

	public static List<String> getLn() {
		return ln;
	}

	public static void setLn(List<String> ln) {
		HashPname.ln = ln;
	}

	public static Map<String, List<String>> getPn() {
		return pn;
	}

	public static void setPn(Map<String, List<String>> pn) {
		HashPname.pn = pn;
	}

}
