package edu.umsl.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewGetPost")
public class ViewGetPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String cont = request.getParameter("content");
		String pg = request.getParameter("pg");

		out.println("Title: " + title + "<br />");
		out.println("Content: " + cont + "<br />");
		out.println("Page: " + pg + "<br />");
		
		String[] titleArr = request.getParameterValues("title");
		
		for (int i = 0; i < titleArr.length; i++) {
			out.println("Title[" + (i + 1) + "]: " + titleArr[i] + "<br />");
		}

		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
