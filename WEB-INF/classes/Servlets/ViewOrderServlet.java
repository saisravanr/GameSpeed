package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;


import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewOrderServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Update up = new Update();
		String id = (String) req.getSession().getAttribute("email");
		List<String> values = HashPname.getPn().get(id);
		List<Double> val = HashPprice.getPp().get(id);
		PrintWriter pw = resp.getWriter();
		
		String remove = req.getParameter("del");
		int rem;
		
		try {
			List<Double> valu = Update.m2.get(id);
			List<String> valus = Update.m3.get(id);
			rem = Integer.parseInt(remove);
			HashPname.getPn().get(id).remove(values.get(rem));
			HashPprice.getPp().get(id).remove(val.get(rem));
			Update.m3.get(id).remove(valus.get(rem));
			Update.m2.get(id).remove(valu.get(rem));
			
						
		} catch (Exception e) {
			//rem = 1;
		}
		
		if(HashPname.getPn().isEmpty() || values.isEmpty()){
			try{
			Update.m2.get(id).removeAll(Update.l2);
			Update.m3.get(id).removeAll(Update.l3);
			pw.println("<html><head><title>"+"Empty Cart"
					   +"</title>"+"</head>"+"<body align='center'><h1 font face = 'Cambria'>"
					+ "Your Cart is Empty"+"</h1>"+"<a href='Home.html'>Home</a>"+"</body></html>"
					);
			}catch(Exception e){
			pw.println("<html><head><title>"+"Empty Cart"
					   +"</title>"+"</head>"+"<body align='center'><h1 font face = 'Cambria'>"
					+ "Your Cart is Empty"+"</h1>"+"<a href='Home.html'>Home</a>"+"</body></html>"
					);
			}
		}
		else{
			
			
		up.setId(id);
		
		String qty = req.getParameter("qty");
		String itr = req.getParameter("itr");
		double quan;
		int iter;

		try {
			iter = Integer.parseInt(itr);
			quan = Integer.parseInt(qty);
			up.setQuantity(quan);
			up.setItr(iter);
			//up.setMap(iter);
			up.setTotal();
						
		} catch (Exception e) {
			quan = 1;
			//up.setTotal();
			up.setQuantity(quan);
			
		}

		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		String checkoutURL = resp.encodeURL("/Assignment4/check");
		String checkoutURL1 = resp.encodeURL("/Assignment4/Home.html");

		
		pw.println("<HTML>\n" + "<HEAD><TITLE>" + "Your Cart"
				+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#D8D8D8\">\n"
				+ "<H1 ALIGN=\"CENTER\">" + "Your Cart" + "</H1>"
				+ "<TABLE BORDER=1 ALIGN=\"CENTER\">\n"
				+ "<TR BGCOLOR=\"#58FAF4\">\n"
				+ "  <TH>Item ID<TH>Description\n"
				+ "  <TH>Unit Cost<TH>Quantity<TH>Total Cost<TH>Delete");
		
		
		for (int i = 0; i < values.size(); i++) {			
			up.setMap(i);
			List<Double> valu = Update.m2.get(id);
			List<String> valus = Update.m3.get(id);
			pw.println("<TR>\n" + "  <TD>" + valus.get(i) + "\n" + "  <TD>"
					+ valus.get(i) + "\n" + "  <TD>"
					+ formatter.format(val.get(i)) + "\n" + "  <TD>"
					+ "<FORM>\n" + "<INPUT TYPE=\"HIDDEN\" NAME=\"itr\"\n"
					+ "       VALUE=\"" + i + "\">\n"
					+ "<INPUT TYPE=\"TEXT\" REQUIRED NAME=\"qty\"\n"
					+ "       SIZE=3 VALUE=\""+(int)(valu.get(i)/val.get(i))+ "\">\n" + "<SMALL>\n"
					+ "<INPUT TYPE=\"SUBMIT\"\n "
					+ "       VALUE=\"Update\">\n" + "</SMALL>\n"
					+ "</FORM>\n" + "  <TD>" + formatter.format(valu.get(i)) + "<TD>"
					+ "<FORM>\n" + "<INPUT TYPE=\"HIDDEN\" NAME=\"del\"\n"
					+ "       VALUE=\"" + i + "\">\n" + "<SMALL>\n"
					+ "<INPUT TYPE=\"SUBMIT\"\n "
					+ "       VALUE=\"Delete\">\n" + "</SMALL>\n" + "</FORM>\n");
		}

		pw.println("</TABLE>\n" + "<br><br>" + "<FORM ACTION=\"" + checkoutURL
				+ "\">\n" + "<BIG><CENTER>\n" + "<INPUT TYPE=\"SUBMIT\"\n"
				+ "       VALUE=\"Proceed to Checkout\">\n"
				+ "</CENTER></BIG></FORM>" + "  " + "<FORM ACTION=\""
				+ checkoutURL1 + "\">\n" + "<BIG><CENTER>\n"
				+ "<INPUT TYPE=\"SUBMIT\"\n"
				+ "       VALUE=\"Continue Shopping\">\n"
				+ "</CENTER></BIG></FORM>" + "</BODY></HTML>");
		
		
	}
}
}

