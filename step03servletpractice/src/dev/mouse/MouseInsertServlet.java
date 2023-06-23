package dev.mouse;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mice-insert")
public class MouseInsertServlet extends HttpServlet{
	


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder responseHTML = new StringBuilder();
		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<meta charset=\"UTF-8\"/>");
		responseHTML.append("		<title>Mouse 등록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("		<body>");

		final String URL = "\"add\"";
		final String HTTP_METHOD = "\"POST\"";

		String formAttribute = String.format("action=%s method=%s", URL, HTTP_METHOD);
		responseHTML.append("<h1>Mouse 등록 페이지</h1>");
		responseHTML.append("			<form " + formAttribute + ">");

		String nameInputAttribute = "type=\"text\" name=\"name\"";
		responseHTML.append("			name: <input " + nameInputAttribute + "><br/>");

		String countryInputAttribute = "type=\"text\" name=\"country\"";
		responseHTML.append("			country: <input " + countryInputAttribute + "><br/>");

		String addressInputAttribute = "type=\"text\" name=\"address\"";
		responseHTML.append("			address: <input " + addressInputAttribute + "><br/>");

		String buttonAttribute = "type=\"submit\"";
		responseHTML.append("			<button " + buttonAttribute + ">등록</button><br/>");
		responseHTML.append("		</body>");
		
		response.setContentType("text/html"); // 응답 객체에 이 문서의 타입은 HTML이라고 명시
		response.setCharacterEncoding("UTF-8"); // 응답 객체에 이 문서의 문자셋 인코딩은 UTF-8이라고 명시

		response.setStatus(200);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print(responseHTML);
		
				
	}
	
	
	
	

}
