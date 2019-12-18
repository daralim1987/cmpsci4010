package edu.umsl.java.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewRequest")
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String ipaddr = request.getRemoteAddr();
		String client = request.getHeader("User-Agent");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println(ipaddr);
		out.println("<br />");
		out.println(client);
		out.println("<br />");

		String line = null;

		try {
			BufferedReader reader = request.getReader();

			while ((line = reader.readLine()) != null) {
				out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

}
