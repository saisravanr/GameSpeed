package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SalesmanLoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			Boolean b = HashMaSa.getHmsa().containsKey(email);

			if (b && HashMaSa.getHmsa().get(email).equals(password)) {
				// req.getSession().setAttribute("email", email);
				resp.sendRedirect("Home.html");
			} else {
				pw.println("<html>");
				pw.println("<head><title>Invalid</title></head>");
				pw.println("<body align='center'>Invalid Username/Password<br>");
				pw.println("<br><a href='Rlogin.html'>Try again</a>");
				pw.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
