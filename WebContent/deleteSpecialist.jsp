<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="r3sysSomya.com.DbConnection" %>
<%

	Connection con = DbConnection.connect();
	int sid = Integer.parseInt(request.getParameter("sid"));
	PreparedStatement pstmt1 = con.prepareStatement("delete from addspecialistdoctor where sid=?");
	pstmt1.setInt(1,sid);
	int i= pstmt1.executeUpdate();		

	if(i>0){%>
		<h3>Your Account Deleted Suceesfully </h3>
	<% }%>
</body>
</html>