package Servlets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreMLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {

			String email = req.getParameter("usermail");
			String password = req.getParameter("password");

			Boolean b = HashMaSt.getHmst().containsKey(email);

			if (b && HashMaSt.getHmst().get(email).equals(password)) {
				pw.println("<HTML>\n" + "<HEAD><TITLE>" + "StoreManagerLogin"
						+ "</TITLE></HEAD>\n" + "<BODY BGCOLOR=\"#D8D8D8\">\n"
						+ "<H1 ALIGN=\"CENTER\">" + "Welcome" + "</H1>"
						+ "<BODY>"

						+ "<FORM action='adu' method='get'>"
						+ "<label>Product Name:</label>"
						+ "<input type='text' name ='pname'>" + "<br><br>"
						+ "<label>Product Price:</label>"
						+ "<input type='text' name ='pprice'>" + "<br><br>"
						+ "<input type = 'submit' value='Add' name='add'>"
						+ "</FORM>" + "<BODY>" + "<HTML>" + "<br><br><br>"

						+ "<FORM action='adu' method='get'>"
						+ "<label>Product Name:</label>"
						+ "<input type='text' name ='pname'>" + "<br><br><br>"
						+ "<input type = 'submit' value='Delete' name='del'>"
						+ "</FORM>" + "<BODY>" + "<HTML>" + "<br><br>"

						+ "<FORM action='adu' method='get'>"
						+ "<label>Product Name:</label>"
						+ "<input type='text' name ='pname'>" + "<br><br><br>"
						+ "<label>Updated Product Price:</label>"
						+ "<input type='text' name ='pprice'>" + "<br><br>"
						+ "<input type = 'submit' value='Update' name='upd'>"
						+ "</FORM>" + "<br><br><br><br>"
						+ "<a href='Index.html'><button>Sign Out</button></a>"
						+ "<BODY>" + "<HTML>");

			} else {
				pw.println("<html>");
				pw.println("<head><title>Invalid</title></head>");
				pw.println("<body align='center'>Invalid Username/Password<br>");
				pw.println("<br><a href='Smlogin.html'>Try again</a>");
				pw.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
