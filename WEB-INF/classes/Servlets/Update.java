package Servlets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Update {

	double quantity;
	int itr;
	int i;
	String id;
	double total;
	
	public static Map<String, List<Double>> m2 = new HashMap<String, List<Double>>();
	public static List<Double> l2 = new ArrayList<>();
	
	public static Map<String, List<String>> m3 = new HashMap<String, List<String>>();
	public static List<String> l3 = new ArrayList<>();

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getItr() {
		return itr;
	}
	public void setItr(int itr) {
		this.itr = itr;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public void setMap(int i){
		List<String> values = HashPname.getPn().get(id);
		List<Double> val = HashPprice.getPp().get(getId());
		List<Double> valu = m2.get(getId());
		List<String> valus = m3.get(getId());
		try{
		if((valu.get(i)%val.get(i)) == 0 ){
			
			//valu.set(i, (val.get(i)*(getQuantity()+1)));
		}
		else{
		l2.add(val.get(i));
		m2.put(getId(), l2);
		l3.add(values.get(i));
		m3.put(getId(), l3);
		}
		}catch(Exception e){
			
			l2.add(val.get(i));
			m2.put(getId(), l2);
			l3.add(values.get(i));
			m3.put(getId(), l3);
			
		}
		}
			
	public void setTotal(){
		
		List<Double> val = HashPprice.getPp().get(getId());
		List<String> values = HashPname.getPn().get(id);
		List<Double> valu = m2.get(getId());
		List<String> valus = m3.get(getId());
		
		total = (val.get(getItr()))* getQuantity();
		
		valus.set(getItr(), values.get(getItr()));
		valu.set(getItr(), total);
		
		System.out.println(m2);
	}

}
