package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class OrderItems extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		try {
			String id = (String) req.getSession().getAttribute("email");
			List<String> values = HashPname.getPn().get(id);
			List<Double> val = HashPprice.getPp().get(id);
			List<Double> valu = Update.m2.get(id);
			MongoClient mg = new MongoClient("localhost", 27017);
			DB mdb = mg.getDB("Assignment1");

			DBCollection orders = mdb.getCollection("Orders");

			Calendar c = Calendar.getInstance();

			c.add(Calendar.DATE, 14);

			
			Random r = new Random(System.currentTimeMillis());
			Long orderid = (long) (10000 + r.nextInt(20000));

			
			
			for (int i = 0; i < values.size(); i++) {
				BasicDBObject bdo = new BasicDBObject("key", "value");
				bdo.append("userid", id).append("orderid", orderid);
				bdo.append("pname", values.get(i)).append("pprice", val.get(i));
				bdo.append("quantity", (valu.get(i)/val.get(i)));
				orders.insert(bdo);
			}

			
			pw.println("<html><head><tittle><h1>Order Details</h1></title></head>"
					  +"<body align ='center' bgcolor='#D8D8D8'>"
					  +"<h3>Order Placed Successfully"
					  +"<br>"
					  +"Your Order Id is: "+ orderid
					  +"<br>"
					  +"Expected delivery date is: "+ c.getTime()
					  +"</h3>"
					  +"<a href='Home.html'>Home</a>"
					  +"</body>"
					  +"</html>"
					);
			
			HashPname.getPn().clear();
			HashPprice.getPp().clear();
			HashPname.getLn().clear();
			HashPprice.getLp().clear();
			Update.m2.clear();
			Update.l2.clear();
			Update.m3.clear();
			Update.l3.clear();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
