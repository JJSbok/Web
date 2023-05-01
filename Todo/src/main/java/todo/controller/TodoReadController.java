package todo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TodoReadController
 */
@WebServlet("/todo/read")
public class TodoReadController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 상세보기 페이지 get 요청에 화면을 보여주는 처리
		// 어떤 Todo의 데이터인지 식별할 수 있는 키 데이터 받아서 처리
		String noStr = request.getParameter("no");
		int no = Integer.parseInt(noStr);

		// no 값으로 Service를 통해서 Todo 정보를 받아옴!
		String todo = "청소";
		String dueDate = "2023-05-01";
		String complete = "done";

		request.setAttribute("no", no);
		request.setAttribute("todo", todo);
		request.setAttribute("dueDate", dueDate);
		request.setAttribute("complete", complete);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/todo/read.jsp");
		dispatcher.forward(request, response);

	}

}