package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Checkout extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("<HTML>\n" + "<HEAD><TITLE>" + "Checkout"
				+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#D8D8D8\">\n"
				+ "<H1 ALIGN=\"CENTER\">" + "Checkout" + "</H1>" + "<BODY align='center'>"
				+ "<FORM action='orderi' method='get'>"
				+ "<table align='center'>"
				+ "<tr>"
				+ "<td><label>Name:</label></td>" + "<td><input type='text' name ='name'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td><label>Address:</label></td>"
				+ "<td><input type='text' name ='address'></td>"
				+ "</tr>"
				+"<tr>"
				+ "<td><label>Credit Card No:</label></td>"
				+ "<td><input type='text' name ='credit'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td><label>CVV:</label></td>" + "<td><input type='text' name ='cvv'></td>"
				+ "</tr>"
				+"</table>"
				+"<br><br>"
				+ "<input type = 'submit' value='Place Order' name='add'>"
				+"<br><br>"
				+"<a href='Home.html'>Home</a>"
				+ "</FORM>" + "<BODY>" + "<HTML>" + "<br><br><br>");
	}
}
