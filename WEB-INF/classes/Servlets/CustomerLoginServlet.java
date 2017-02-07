package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			Boolean b = HashMa.getHm().containsKey(email);

			if (b && HashMa.getHm().get(email).equals(password)) {
				req.getSession().setAttribute("email", email);
				
				HashPname.getPn().clear();
				HashPprice.getPp().clear();
				HashPname.getLn().clear();
				HashPprice.getLp().clear();
				Update.m2.clear();
				Update.l2.clear();
				Update.m3.clear();
				Update.l3.clear();
				resp.sendRedirect("Home.html");
				
				
			} else {
				pw.println("<html>");
				pw.println("<head><title>Invalid</title></head>");
				pw.println("<body align='center'>Invalid Username/Password<br>");
				pw.println("<br><a href='Clogin.html'>Try again</a>");
				pw.println("</html>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
