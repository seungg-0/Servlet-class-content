package dev.syntax.step01helloservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * 2. Annotation(@) 기반 맵핑
 * XML을 통한 관리 방식의 번거로움
 * 추상화되고 직관적인 Annotation을 통해 간소화
 * -> @WebServlet Annotation 활용
 * ref. https://javaee.github.io/javaee-spec/javadocs/javax/servlet/annotation/WebServlet.html
 */

@WebServlet(name = "SecondServlet", urlPatterns = "/servlets/second-servlet")
public class SecondServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest requsest, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("두번째 서블릿 호출 ~~~~~~~~~~~~~~~");
	}
	
	
	
	

}
