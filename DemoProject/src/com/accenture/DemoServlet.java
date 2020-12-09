package com.accenture;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.sql.Blob;
//import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;

@WebServlet({ "/DemoServlet", "/demoservlet" })
//@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class DemoServlet extends HttpServlet {

	String url = "jdbc:mysql://localhost:3306/myproject";
	String user = "root";
	String password = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/myproject";
		String user = "root";
		String password = "";
		
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String uname = request.getParameter("username");
		String age = request.getParameter("age");
		String pass = request.getParameter("password");

//		InputStream inputStream = null; // input stream of the upload file
//		
//		// obtains the upload file part in this Multipart request
//		Part filePart = request.getPart("image");
//		
//		if (filePart != null) {
//			// prints out some information for debugging
//			System.out.println(filePart.getName());
//			System.out.println(filePart.getSize());
//			System.out.println(filePart.getContentType());
//
//			// obtains input stream of the upload file
//			// the InputStream will point to a stream that contains
//			// the contents of the file
//			inputStream = filePart.getInputStream();
//		}

		try {
			// Loading the driver
			Class.forName("com.mysql.jdbc.Driver");

			// Establishing connection
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = ("INSERT INTO users (name, email,uname,Age,password) values (?, ?, ?, ?, ?)");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, uname);
			st.setString(4, age);
			st.setString(5, pass);
//			st.setBlob(6, inputStream);
			int row = st.executeUpdate();

			// rows affected
			System.out.println(row + "Row affected");
			response.sendRedirect("login1.html");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
