

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		String url ="jdbc:mysql://localhost:3307?user=root&password=12345";
	
		String querry = "insert into exampledb.register values(?,?)";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url);
		PreparedStatement st = con.prepareStatement(querry);
		st.setString(1,name);
		st.setString(2,password);
		st.executeUpdate();
		out1.print("welcome " +name+" succesfully");
		st.close();
		con.close();
		
		}catch(Exception e) {e.printStackTrace();}
		


	}

	}

	


