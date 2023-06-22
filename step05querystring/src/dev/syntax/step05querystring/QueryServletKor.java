// -*- coding: UTF-8 -*-
package dev.syntax.step05querystring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-kor")
public class QueryServletKor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println(name);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>GET 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식에서의 한글 처리 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println(name);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>GET방식");
		
		
	}

}
