package dev.mouse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.mouse.domain.Mouse;
import dev.mouse.repository.MouseDAO;

@WebServlet("/mice")
public class MouseListServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 처리
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		MouseDAO mouseDAO = new MouseDAO();
		// DB에 가서 전체 Mouse 목록 가져오는 처리(사장이 요리하는 부분)
		List<Mouse> mice = null;
		try {
			mice = mouseDAO.findAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// mice 데이터를 HTML 페이지에 바인딩하여 렌더링
		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("	<head>");
		responseHTML.append("		<title>Mouse 목록 페이지</title>");
		responseHTML.append("	</head>");
		responseHTML.append("	<body>");
		responseHTML.append("<h1>Mouse 목록 페이지</h1>");
		responseHTML.append("<ul>");

		String liStyle = "style=\"display:flex; list-style:none;\"";
		for (Mouse mouse : mice) {
			responseHTML.append("<li " + liStyle + ">");
			responseHTML.append(String.format("<div>%s</div>", mouse.getId()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getName()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getCountry()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getAddress()));
			responseHTML.append("</li>");

		}
		responseHTML.append("</ul>");

		responseHTML.append("	</body>");
		responseHTML.append("		</html>");
		
		PrintWriter writer = response.getWriter();
		writer.write(responseHTML.toString());
	}
}
