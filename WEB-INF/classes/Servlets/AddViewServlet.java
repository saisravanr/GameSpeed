package Servlets;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class AddViewServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

		PrintWriter pw = resp.getWriter();
		
	
		try {
			String sparam = req.getParameter("prname");

			if (req.getParameter("viewreview") != null) {

				MongoClient mg = new MongoClient("localhost", 27017);
				DB mdb = mg.getDB("Assignment1");

				DBCollection creviews = mdb.getCollection("CustomerReviews");

				BasicDBObject bdo = new BasicDBObject();
				bdo.put("pmodel", sparam);

				DBCursor c = creviews.find(bdo);

				pw.println("<html>");
				pw.println("<head><title>User Reviews</title> </head>");
				pw.println("<body>");
				pw.println("<h2 font face ='Cambria'> User Reviews:" + sparam
						+ "</h2>");

				pw.println("<a href='Home.html'>Home</a>");
				pw.println("<br><br>");

				if (c.count() == 0) {
					pw.println("No one has reviewed this product yet.");

				} else {
					pw.println("<table>");

					while (c.hasNext()) {

						BasicDBObject bd = (BasicDBObject) c.next();

						pw.println("<tr>");
						pw.println("<td> Product Name </td>");
						pw.println("<td>: </td>");
						String pmodel = bd.getString("pmodel");
						pw.println("<td>" + pmodel + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Product Category </td>");
						pw.println("<td>: </td>");
						String pcategory = bd.getString("pcategory");
						pw.println("<td>" + pcategory + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Product Price </td>");
						pw.println("<td>: </td>");
						double pprice = bd.getDouble("pprice");
						pw.println("<td>" + pprice + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Retailer Name </td>");
						pw.println("<td>: </td>");
						String retailer = bd.getString("retailer");
						pw.println("<td>" + retailer + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Retailer Zip </td>");
						pw.println("<td>: </td>");
						String rzip = bd.getString("rzip");
						pw.println("<td>" + rzip + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Retailer City </td>");
						pw.println("<td>: </td>");
						String rcity = bd.getString("rcity");
						pw.println("<td>" + rcity + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Retailer State </td>");
						pw.println("<td>: </td>");
						String rstate = bd.getString("rstate");
						pw.println("<td>" + rstate + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Product On Sale </td>");
						pw.println("<td>: </td>");
						String pos = bd.getString("pos");
						pw.println("<td>" + pos + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Manufacturer Name </td>");
						pw.println("<td>: </td>");
						String mname = bd.getString("mname");
						pw.println("<td>" + mname + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Manufacturer Rebate </td>");
						pw.println("<td>: </td>");
						String mrebate = bd.getString("mrebate");
						pw.println("<td>" + mrebate + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> User Id </td>");
						pw.println("<td>: </td>");
						String userid = bd.getString("userid");
						pw.println("<td>" + userid + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Age </td>");
						pw.println("<td>: </td>");
						int uage = bd.getInt("uage");
						pw.println("<td>" + uage + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Gender </td>");
						pw.println("<td>: </td>");
						String gender = bd.getString("gender");
						pw.println("<td>" + gender + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Occupation </td>");
						pw.println("<td>: </td>");
						String occu = bd.getString("occu");
						pw.println("<td>" + occu + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Rating </td>");
						pw.println("<td>: </td>");
						int rating = bd.getInt("rating");
						pw.println("<td>" + rating + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Date </td>");
						pw.println("<td>: </td>");
						String rdate = bd.getString("rdate");
						pw.println("<td>" + rdate + "</td>");
						pw.println("</tr>");

						pw.println("<tr>");
						pw.println("<td> Review Text: </td>");
						pw.println("<td>: </td>");
						String reviewt = bd.getString("reviewt");
						pw.println("<td>" + reviewt + "</td>");
						pw.println("</tr>");
					}

				}
			} else if (req.getParameter("addtocart") != null) {

				String email = (String) req.getSession().getAttribute("email");
				String prname = req.getParameter("prname");
				double prprice = Double
						.parseDouble(req.getParameter("prprice"));
				
				
							

				
				HashPname.getLn().add(prname);
				HashPname.getPn().put(email, HashPname.getLn());

				HashPprice.getLp().add(prprice);
				HashPprice.getPp().put(email, HashPprice.getLp());
				resp.sendRedirect("/Assignment4/vieworder");
			}

		} catch (MongoException m) {
			m.printStackTrace();
		}

	}
}
