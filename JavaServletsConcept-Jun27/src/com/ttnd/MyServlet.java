package com.ttnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(true);
		if (sess.getAttribute("username") != null) {
			sess.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("<font color=red>Logged out!! Come back soon</font>");
			rd.include(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "admin");
			ResultSet rs;

			PreparedStatement stmt = con.prepareStatement("select * from login  where uid=? and pass=?");

			stmt.setString(1, request.getParameter("username"));
			stmt.setString(2, request.getParameter("password"));

			rs = stmt.executeQuery();

			if (rs.next()) {

				HttpSession sess = request.getSession(true);
				sess.setAttribute("username", request.getParameter("username"));
				response.sendRedirect("blog.jsp");

			} else {

				try {
					PrintWriter out = response.getWriter();
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					out.println("<font color=red>Invalid Credentials!!! Please try again</font>");
					rd.include(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
