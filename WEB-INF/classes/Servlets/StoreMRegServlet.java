package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreMRegServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String cpassword = req.getParameter("cpassword");

			if (cpassword.equals(password)) {

				HashMaSt.getHmst().put(email, password);

				pw.println("<html>");
				pw.println("<head><title>Account Created</title></head>");
				pw.println("<body align='center'>Account created successfully<br>");
				pw.println("<br><a href='Smlogin.html'>Click here to login</a>");
				pw.println("</html>");
			} else {
				pw.println("<html>");
				pw.println("<head><title>Incorrect Password</title></head>");
				pw.println("<body align='center'>Passwords do not match<br>");
				pw.println("<br><a href='Smreg.html'>Click here to re-enter</a>");
				pw.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
