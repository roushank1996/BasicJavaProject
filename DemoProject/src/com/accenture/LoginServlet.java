package com.accenture;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/myproject";
		String user = "root";
		String password = "";
		
//		System.out.println("wewrteyfhgcv");
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");

		try {
			// Loading the driver
			Class.forName("com.mysql.jdbc.Driver");

			// Establishing connection
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected");
			String sql = ("Select uname,password from users");
			
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			
			while(rs.next())  
			{
				if(uname.equals(rs.getString(1)) && pass.equals(rs.getString(2)) )
				{
					response.sendRedirect("index.html");
				}
				else
					response.sendRedirect("error.jsp");
			} 
			  

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
