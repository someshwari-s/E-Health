package r3sysSomya.com;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addpatient
 */
@WebServlet("/addpatient")
public class addpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addpatient() {
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
		int pid =0;
		 String patientname = request.getParameter("patientname");
		 String age = request.getParameter("age");
		 String gender = request.getParameter("gender");
		 String address = request.getParameter("address");
		 String mobno = request.getParameter("mobno");
		 String symptom1 = request.getParameter("symptom1");
		 String symptom2 = request.getParameter("symptom2");
		 String symptom3 = request.getParameter("symptom3");
		 try{
		 java.sql.Connection con = DbConnection.connect();
		 PreparedStatement pstmt = con.prepareStatement("INSERT INTO `ehealth`.`addpatient` (`pid`, `patientname`, `age`, `gender`, `address`, `mobno`, `symptom1`, `symptom2`, `symptom3`) VALUES (?,?,?,?,?,?,?,?,?)");
		 pstmt.setInt(1,pid);
		 pstmt.setString(2,patientname);
		 pstmt.setString(3,age);
		 pstmt.setString(4,gender);
		 pstmt.setString(5,address);
		 pstmt.setString(6,mobno);
		 pstmt.setString(7,symptom1);
		 pstmt.setString(8,symptom2);
		 pstmt.setString(9,symptom3);
		 
		 int i = pstmt.executeUpdate();
		 if(i>0){
				response.sendRedirect("viewpatient.jsp");
			}
		}catch (SQLException e) {
			System.out.println("Invalid Details");
		}	
	}
}
