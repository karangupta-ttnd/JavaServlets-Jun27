package com.ttnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet("/BlogServlet")
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sess =request.getSession(true);
		 if(sess.getAttribute("username")==null){
			 response.sendRedirect("index.jsp");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		HttpSession sess =request.getSession();
		PrintWriter out = response.getWriter(); 
		
		 if(sess.getAttribute("username")!=null )
		 {
			 try{
					Class.forName("com.mysql.jdbc.Driver");
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","admin");
				    PreparedStatement  st = con.prepareStatement("insert into blog (blog_id,blog_content ) values (?,?)");    
				    
				    st.setString(1,request.getParameter("blog_id"));
				    st.setString(2,request.getParameter("blog_content"));  
				    
				    int i = st.executeUpdate();
				    
				   if(i>0)
				   {
					   out.println("<html><body>Your response has been saved<br>");
					   out.println("<a href=\"MyServlet\">Logout</a><br>");
					   out.println("<a href=\"blog.jsp\">Go Back</a><br>");
					   out.println("</body></html> ");


				   }
			 }	
				catch(Exception e)
				   {
					   e.printStackTrace();
			}
			 
		 }
		 else{
			 
				try{
					RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
					out.println("<font color=red>Unable to process request.</font>");
					rd.include(request, response);
				}catch(Exception e){e.printStackTrace();} 
		 }
		 
		 
	}

}
