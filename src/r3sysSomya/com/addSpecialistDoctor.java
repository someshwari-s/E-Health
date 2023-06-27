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
 * Servlet implementation class addSpecialistDoctor
 */
@WebServlet("/addSpecialistDoctor")
public class addSpecialistDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSpecialistDoctor() {
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
		
		int sid =0;
		 String dname = request.getParameter("dname");
		 String email = request.getParameter("email");
		 String mobno = request.getParameter("mobno");
		 String password = request.getParameter("password");
		 String city = request.getParameter("city");
		 String specialization = request.getParameter("specialization");
		 String DiseaseTreatment = request.getParameter("diseasetreatment");
		 try{
		 java.sql.Connection con = DbConnection.connect();
		 PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ehealth`.`addspecialistdoctor` (`sid`, `name`, `email`, `mobno`, `password`, `city`, `specialization`, `DiseaseTreatment`) VALUES (?,?,?,?,?,?,?,?)");
		 pstmt.setInt(1,sid);
		 pstmt.setString(2,dname);
		 pstmt.setString(3,email);
		 pstmt.setString(4, mobno);
		 pstmt.setString(5,password);
		 pstmt.setString(6,city);
		 pstmt.setString(7,specialization);
		 pstmt.setString(8,DiseaseTreatment);
		 
		 int i = pstmt.executeUpdate();
		 if(i>0){
				response.sendRedirect("view.jsp");
			}
		 else{
			 response.sendRedirect("Specialist.jsp");
		 }
		}catch (SQLException e) {
			System.out.println("Invalid Details");
			e.printStackTrace();
		}	
	}
}
