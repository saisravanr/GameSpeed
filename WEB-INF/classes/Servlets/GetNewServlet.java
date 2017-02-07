package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetNewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String pname = "";
		ProductStore productStore = new ProductStore();
		Set<String> s = productStore.getProducts().keySet();
		Iterator<String> it = s.iterator();
		
		out.println("<html><head><script type='text/javascript' src='javascript.js'></script>"
				+ "<link rel='stylesheet' type='text/css' href='StyleSheet.css'><title>"
				+ "New Products"
				+ "</title></head>"
				+ "<body onload='init()'><header>"
				+ "<h1><font face='Cambria'>GAMESPEED</font></h1></header>"
				+ "<nav><ul>"
				+ "<li><a href='Home.html' class='home'><font face='Cambria'>HOME</font></a></li>"
				+ "<li><a href='Microsoft.html' class='microsoft'><font face='Cambria'>MICROSOFT</font></a></li>"
				+ "<li><a href='Sony.html' class='sony'><font face='Cambria'>SONY</font></a></li>"
				+ "<li><a href='Nintendo.html' class='nintendo'><font face='Cambria'>NINTENDO</font></a></li>"
				+ "</ul>"
				+ "<a href='Index.html'>SIGN OUT</a> <a href='vieworder'>CART</a>"
				+ "<form name='autofillform' action='autocomplete'>"
				+ "<table border='0'>"
				+ "<tbody>"
				+ "<tr><td>"
				+ "<input type='search' autocomplete='off' id='complete-field' onkeyup='doCompletion()' placeholder='Search...'></td>"
				+ "</tr>"
				+ "	<tr>"
				+ "<td id='auto-row'>"
				+ "<table id='complete-table' class='popupBox' >"
				+ "</table>"
				+ "</td></tr>"
				+ "</tbody>"
				+ "</table>"
				+ "	</form>"
				+ "</nav>"
				+ "<div id='contain'>"
				+ "<section id='desc'>");
		while (it.hasNext()) {
			pname = it.next();
			out.println( "<form action='addview' method='post'>"
					+ "<table class='table-1' align='center'>"
					+ "<tr>"
					+ "<th rowspan='3'><img src='Images/"
					+ productStore.getProducts().get(pname).getProductName()
					+ ".jpg' height='250px' width='220px'></th>"
					+ "<td><input type='submit' name='addtocart' value='Add to Cart'></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td><a href='Writerev.html'>Write Review</a></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td><input type='submit' name='viewreview' value='View Review'></td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td><textarea name='prname' readonly='readonly' rows='1' cols='20'>"
					+ productStore.getProducts().get(pname).getProductName()
					+ "</textarea></td>"
					+ "<td>$<textarea name='prprice' readonly='readonly' rows='1' cols='6'>"
					+ productStore.getProducts().get(pname).getProductPrice()
					+ "</textarea></td>"
					+ "</tr>"
					+ "</table>"
					+ "</form>");

			
	}
		out.println("</section>"
				+ "<aside class='vnav'>"
				+ "<ul><li>"
				+ "<h3>Game Makers</h3>"
				+ "<ul><li><a href='EA.html'>Electronic Arts</a></li>"
				+ "<li><a href='Activision.html'>Activision</a></li>"
				+ "<li><a href='TTI.html'>Take-Two Interactive</a></li>"
				+ "</ul>"
				+ "<li><h3>Products</h3><ul>"
				+ "<li><a href='X1.html'>Xbox One</a></li>"
				+ "<li><a href='X360.html'>Xbox 360</a></li>"
				+ "<li><a href='Ps3.html'>PS3</a></li>"
				+ "<li><a href='Ps4.html'>PS4</a></li>"
				+ "<li><a href='Wii.html'>Wii</a></li>"
				+ "<li><a href='WiiU.html'>WiiU</a></li>"
				+ "</ul>"
				+ "</li>"
				+ "<li><h3>Accessories</h3><ul>"
				+ "<li><a href='Xc.html'>Xbox</a></li>"
				+ "<li><a href='Psc.html'>Play Station</a></li>"
				+ "<li><a href='Wiic.html'>Wii</a></li>"
				+ "</ul>"
				+ "</li>"
				+ "<li><h3>Tablets</h3><ul>"
				+ "<li><a href='Nexus.html'>Nexus</a></li>"
				+ "<li><a href='Ipad.html'>Ipad</a></li>"
				+ "</ul></li>"
				+ "</ul></aside>"
				+ "<div class='clear'></div>"
				+ "<div class='foo'> <p>Copyright © www.gamespeed.co.in</p> </div></div></body></html>");

}
}
