import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/add2")

public class add2 extends HttpServlet {

	
	@Override
	public void service(ServletRequest request, 
			ServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// getParameter�� name Ű���� �����´�.
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int sumer = Integer.parseInt(x) + Integer.parseInt(y);
		String sum = request.getParameter("����");
		
		String summer = String.valueOf(sumer);
		
		summer = request.getParameter(sum);
		out.println("�հ� : " + sumer);
	}
}
