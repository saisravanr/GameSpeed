package Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashPprice {

	private static Map<String, List<Double>> pp = new HashMap<String, List<Double>>();

	private static List<Double> lp = new ArrayList<>();

	public static List<Double> getLp() {
		return lp;
	}

	public static void setLp(List<Double> lp) {
		HashPprice.lp = lp;
	}

	public static Map<String, List<Double>> getPp() {
		return pp;
	}

	public static void setPp(Map<String, List<Double>> pp) {
		HashPprice.pp = pp;
	}

}
