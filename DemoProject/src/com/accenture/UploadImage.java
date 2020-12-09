package com.accenture;

import java.io.IOException;
import java.io.InputStream;
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
 
@WebServlet("/uploadImage")
@MultipartConfig(maxFileSize = 16177216)
public class UploadImage extends HttpServlet{
 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException
		 {
		String connectionURL = "jdbc:mysql://localhost:3306/myproject";
		String user = "root";
		String pass = "";
 
		int result = 0;
		Connection con = null;
		Part part=null;
		System.out.println("qwert");
		try {
			part = req.getPart("image");
		} catch (IllegalStateException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("print");
		if(part != null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
			    con = DriverManager.getConnection(connectionURL, user, pass);
			    System.out.println("connect");
			    PreparedStatement ps = con.prepareStatement("insert into image(image) values(?)");
			    System.out.println("statement");
			    InputStream is = part.getInputStream();
			    System.out.println("inputstream");
			    ps.setBlob(1, is,(int)part.getSize());
//			    ps.setBinaryStream(1, is);
			    System.out.println("psss");
			    result = ps.executeUpdate();
			    System.out.println("afterexec");
			}
			catch(SQLException | ClassNotFoundException |IOException e){
				e.printStackTrace();
			}	
			finally{
				if(con != null){
					try{
						con.close();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}

