package edu.umsl.math.web;

import java.io.IOException;
import java.util.List;

import edu.umsl.math.beans.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umsl.math.dao.ProblemDao;

/**
 * Servlet implementation class ListMathServlet
 */
@WebServlet("/listmath")
public class ListMathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProblemDao probdao = null;

		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		
		int pg = 0;
		String initpg = request.getParameter("pg");

		if (initpg != null) {
			try {
				pg = Integer.parseInt(initpg);
			} catch (Exception e) {
				// skip
			}
		}

		if (pg == 0) {
			pg = 1;
		}
		
		try {
			probdao = new ProblemDao();
			
			int cnt = probdao.getProblemCount();

			int totalpg = (int) Math.ceil(cnt / 10.0);

			request.setAttribute("maxpg", totalpg);
					
			if (pg < 1) {
				pg = 1;
			} else if (pg > totalpg) {
				pg = totalpg;
			}
			
			request.setAttribute("crtpg", pg);
			
			List<Problem> problist = probdao.getProblemListByPage(pg);
			List<Category> categorylist = probdao.getCategoryList();

			
			request.setAttribute("problist", problist);
			request.setAttribute("categorylist", categorylist);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dispatcher.forward(request, response);
	}

}
