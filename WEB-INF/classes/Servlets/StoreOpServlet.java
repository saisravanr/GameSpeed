package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoreOpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		if (req.getParameter("add") != null) {
			String pname = req.getParameter("pname");
			String pprice = req.getParameter("pprice");

			Products products = new Products(pname, pname, pprice);
			ProductStore productStore = new ProductStore();
			productStore.getProducts().put(pname, products);
			
			pw.println("<HTML>" + "<title>Success</title>" + "<body>");
			pw.println("<H2 align='center'>" + "Item Added Successfully"
					+ "<br>" + "Customers can view the products by signing in"
					+ "</H2>");
			pw.println("</body>" + "</html>");
			System.out.println(productStore.getProducts().get(pname).getProductName());
		}

		if (req.getParameter("del") != null) {
			String pname = req.getParameter("pname");

			HashADU.getAdu().remove(pname);
			pw.println("<HTML>" + "<title>Success</title>" + "<body>");
			pw.println("<H2 align='center'>" + "Item Deleted Successfully"
					+ "</H2>");
			pw.println("</body>" + "</html>");
			System.out.println(HashADU.getAdu());
		}

		if (req.getParameter("upd") != null) {
			String pname = req.getParameter("pname");
			String pprice = req.getParameter("pprice");

			HashADU.getAdu().put(pname, pprice);
			pw.println("<HTML>" + "<title>Success</title>" + "<body>");
			pw.println("<H2 align='center'>" + "Item Updated Successfully"
					+ "</H2>");
			pw.println("</body>" + "</html>");
			System.out.println(HashADU.getAdu());
		}
	}
}
