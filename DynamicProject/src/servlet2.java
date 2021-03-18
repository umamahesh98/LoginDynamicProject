

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


@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		String url ="jdbc:mysql://localhost:3307?user=root&password=12345";
	
		String querry = "select * from exampledb.register where uername=? AND password=?";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url);
		
		PreparedStatement st = con.prepareStatement(querry);
		st.setString(1,uname);
		st.setString(2, pword);
	
	}
		catch(Exception e) {e.printStackTrace();}

}
} 
