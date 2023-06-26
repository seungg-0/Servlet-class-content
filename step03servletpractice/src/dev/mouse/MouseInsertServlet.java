package dev.mouse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.mouse.domain.Mouse;
import dev.mouse.repository.MouseDAO;
@WebServlet("/add")
public class MouseInsertServlet extends HttpServlet{
	private MouseDAO mouseDAO;
	public MouseInsertServlet() {
		this.mouseDAO = new MouseDAO();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String address = req.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
	    try {
			mouseDAO.add(newMouse);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
//	    String path = "/mice";
//	    RequestDispatcher dispatcher = req.getRequestDispatcher("/mice");
//	    dispatcher.forward(req, resp);
	    resp.sendRedirect(req.getContextPath() + "/mice");
	}
	
}