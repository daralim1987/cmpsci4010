package edu.umsl.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umsl.java.beans.Problem;
import java.util.*;

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
		
		if (qnum.equals("3")) {
			String pv = request.getParameter("my data");
                        
                        request.setAttribute("pv", pv);
			
			dispatcher = request.getRequestDispatcher("result.jsp");
		} else if (qnum.equals("13")) {
			Map<String, String> mymap = new HashMap<String, String>();
                        
                        mymap.put("4", "data4");
			
			request.setAttribute("mymap", mymap);
                        
                        List<String> lstdat = new ArrayList<String>();
                        
                        lstdat.add("abc");
                        lstdat.add("123");
                        lstdat.add("xyz");
                        
                        request.setAttribute("mylst", lstdat);
                        
                        String[] myarr = {"aaa","bbb", "ccc"};
                                
                        request.setAttribute("myarr", myarr);
                        
                        Problem prob = new Problem();
                                
                        prob.setPid(1);
                        prob.setContent("myprob");
                        prob.setOrder_num(2);
                        
                        request.setAttribute("myprob", prob);
			
			dispatcher = request.getRequestDispatcher("result.jsp");
		} else if (qnum.equals("22")) {
			dispatcher = request.getRequestDispatcher("result.jsp?chap=5");
		}
		
		dispatcher.forward(request, response);
		
	}

}
