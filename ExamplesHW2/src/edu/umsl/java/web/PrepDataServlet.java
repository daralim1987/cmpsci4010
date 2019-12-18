package edu.umsl.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umsl.java.beans.Problem;

/**
 * Servlet implementation class PrepDataServlet
 */
@WebServlet("/prepdata")
public class PrepDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;

		String qnum = request.getParameter("qn");
		
		request.setAttribute("qn", qnum);
		
		if (qnum.equals("14")) {
			// Data preparation is in the result JSP
			
			dispatcher = request.getRequestDispatcher("result.jsp");
		} else if (qnum.equals("20")) {
			Problem myprob = new Problem();
			
			myprob.setPid(3);
			myprob.setContent("A Great Math Problem");
			myprob.setOrder_num(1);
			
			request.setAttribute("myprob", myprob);
			
			request.setAttribute("prob", null);
			
			dispatcher = request.getRequestDispatcher("result.jsp");
		} else if (qnum.equals("22")) {
			dispatcher = request.getRequestDispatcher("result.jsp?chap=5");
		}
		
		dispatcher.forward(request, response);
		
	}

}
