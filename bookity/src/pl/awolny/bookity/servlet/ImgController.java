package pl.awolny.bookity.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*; 

@MultipartConfig
@WebServlet("/img")
public class ImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionURL = "jdbc:mysql://localhost:3306/bookity";
		String id = request.getParameter("book_id");

		ResultSet rs = null;
		// Declare statement.
		PreparedStatement ps = null;
		// declare InputStream object to store binary stream of given image.
		InputStream sImage;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(connectionURL, "username", "password");

			ps = connection.prepareStatement("SELECT photo FROM book WHERE book_id = ?");
			ps.setString(1, id); 
			rs = ps.executeQuery();
			if(rs.next()) {
				byte[] bytearray = new byte[1048576];
				int size=0;
				sImage = rs.getBinaryStream(1);
				response.reset();
				response.setContentType("image/jpeg");
				while((size=sImage.read(bytearray))!= -1 ){
					response.getOutputStream().write(bytearray,0,size);
				}
			}
		} catch(Exception ex){
			System.out.println("error :"+ex);
		}
		finally {
		// close all the connections.
		//rs.close();
		//psmnt.close();
		//connection.close();
		}
	}
}