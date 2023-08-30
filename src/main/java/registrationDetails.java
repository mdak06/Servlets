

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
 * Servlet implementation class registrationDetails
 */
@WebServlet("/registrationDetails")
public class registrationDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	Connection con=null;
	
    public void init() {
        // TODO Auto-generated constructor stub
    	{
    		try {
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521.ex","kalam","123456");
    			
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
	 	response.setContentType("text/html");
    	String sname=request.getParameter("sname");
    	String f_name= request.getParameter("fname");
    	int age = Integer.parseInt(request.getParameter("age"));
    	
    	try {
    		PreparedStatement pst=con.prepareStatement("insert into registrationDetails values(?,?,?)");
    		pst.setString(1,sname);
    		pst.setString(2, f_name);
    		pst.setInt(3, age);
    		
    		int num=pst.executeUpdate();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    		
    	pw.println("Welcome"+sname);
	}

    	

	}


