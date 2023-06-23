package step06statemanaging.step02session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	// 로그아웃 처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate(); // 세션 정보를 날림 
			out.print("로그아웃 완료");
		} else {
			out.print("로그인 상태가 아닙니다.");
		}
		
		out.close();
	}

}
