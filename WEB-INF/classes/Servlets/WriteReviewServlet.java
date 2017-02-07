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
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class WriteReviewServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		try {
			String pmodel = req.getParameter("pmodel");
			String pcategory = req.getParameter("pcategory");
			double pprice = Double.parseDouble(req.getParameter("pprice"));
			String retailer = req.getParameter("retailer");
			String rzip = req.getParameter("rzip");
			String rcity = req.getParameter("rcity");
			String rstate = req.getParameter("rstate");
			String pos = req.getParameter("pos");
			String mname = req.getParameter("mname");
			String mrebate = req.getParameter("mrebate");
			String userid = req.getParameter("userid");
			int uage = Integer.parseInt(req.getParameter("uage"));
			String gender = req.getParameter("gender");
			String occu = req.getParameter("occu");
			int rating = Integer.parseInt(req.getParameter("rating"));
			String rdate = req.getParameter("rdate");
			String reviewt = req.getParameter("reviewt");

			MongoClient mg = new MongoClient("localhost", 27017);
			DB mdb = mg.getDB("Assignment1");

			DBCollection creviews = mdb.getCollection("CustomerReviews");

			BasicDBObject bdo = new BasicDBObject("name", "value")
					.append("productName", pmodel).append("productCategory", pcategory)
					.append("productPrice", pprice).append("retailerName", retailer)
					.append("retailerZipcode", rzip).append("retailerCity", rcity)
					.append("retailerState", rstate).append("productOnSale", pos)
					.append("consoleManufacturer", mname).append("manufacturerRebate", mrebate)
					.append("userID", userid).append("userAge", uage)
					.append("userGender", gender).append("userOccupation", occu)
					.append("reviewRating", rating).append("reviewDate", rdate)
					.append("reviewText", reviewt);

			creviews.insert(bdo);

			pw.println("<html>");
			pw.println("<head><title>Write Review</title></head>");
			pw.println("<body align='center'>Thank You!<br>");
			pw.println("<body align='center'>Review has been submitted successfully<br>");
			pw.println("<br><a href='Home.html'>Home</a>");
			pw.println("</html>");

		} catch (MongoException m) {
			m.printStackTrace();
		}
	}
}
