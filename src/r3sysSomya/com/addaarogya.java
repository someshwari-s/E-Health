package r3sysSomya.com;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class addaarogya
 */
@WebServlet("/addaarogya")
public class addaarogya extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addaarogya() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 int aid =0;
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String mobno = request.getParameter("mobno");
		 String village = request.getParameter("village");
		 String district = request.getParameter("district");
		 try{
			 java.sql.Connection con=DbConnection.connect();
		
		 PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ehealth`.`add aarogya` (`aid`, `name`, `email`, `password`, `mobno`, `village`, `District`) VALUES (?,?,?,?,?,?,?)");
		 pstmt.setInt(1,aid);
		 pstmt.setString(2,name);
		 pstmt.setString(3,email);
		 pstmt.setString(4,password);
		 pstmt.setString(5, mobno);
		 pstmt.setString(6,village);
		 pstmt.setString(7,district);
		 
		 int i = pstmt.executeUpdate();
		 if(i>0){
				response.sendRedirect("viewaarogya.jsp");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid Details");
		}	
		
	}
}
