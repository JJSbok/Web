package firstweb;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({ "/now", "/test/now" })
public class DateServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {


		response.setContentType("text/html; charset=UTF-8");
		
		Date now = new Date();
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body>");
		out.println("<h1>안녕하세요</h1>");
		out.println("<h3>"+now.toString()+"</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
