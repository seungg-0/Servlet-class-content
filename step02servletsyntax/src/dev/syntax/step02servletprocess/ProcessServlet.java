package dev.syntax.step02servletprocess;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlets/process-servlet")
public class ProcessServlet extends HttpServlet {
	
	// 기본 생성자 (사용자 요청 시 인스턴스가 생성됨) "싱글톤"으로 동작 (브라우저를 새로고침 해도 인스턴스가 재생성되지 않는다)
	public ProcessServlet() {
		System.out.println("생성자 호출");
		
	}
		
	// 일반 url 경로(GET)로 요청시 doGet이 호출됨
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("~~~");
	}

	// 표준 HTTP Request를 public serviet()로부터 전달 받아서 doXxx() 호출(ex. doGet())
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("protected service() called");
		super.service(req, resp);
	}
	
	// 클라이언트의 외부 request를 protected service()에게 전달c
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("public service() called");
		super.service(req, res);
	}
	
	
	

}
