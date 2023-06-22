package dev.syntax.step05querystring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/query-test-eng")
public class QueryServletEng extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		PrintWriter out = response.getWriter();
		
//		String id = request.getParameter("id");
//		String password = request.getParameter("pwd");
//		String name = request.getParameter("name");
//		String[] hobbys = request.getParameterValues("hobby");
//		String gender = request.getParameter("gender");
//		String nationality = request.getParameter("country");
//		String introduction = request.getParameter("introduction");
//		
//		System.out.println("ID: "+ id);
//		System.out.println("비밀번호: "+ password);
//		System.out.println("이름: "+ name);
//		System.out.println("취미: "+Arrays.toString(hobbys));
//		System.out.println("성별: "+gender);
//		System.out.println("국적: "+nationality);
//		System.out.println("소개: "+introduction);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post called");
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobbys = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String nationality = request.getParameter("country");
		String introduction = request.getParameter("introduction");
		
		System.out.println("ID: "+ id);
		System.out.println("비밀번호: "+ password);
		System.out.println("이름: "+ name);
		System.out.println("취미: "+Arrays.toString(hobbys));
		System.out.println("성별: "+gender);
		System.out.println("국적: "+nationality);
		System.out.println("소개: "+introduction);
		
	}
	
	

}
