package todo.util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class Loader
 */
@WebServlet("/aa")
public class Loader extends HttpServlet {

	
	@Override
	public void init() throws ServletException {
		super.init();
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Loader...init()...");
		
		// 데이터베이스 드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("mysql 드라이버 로드 완료 ...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패 ....");
			e.printStackTrace();
		}
	}

}
