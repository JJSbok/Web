package todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.domain.RequestTodo;
import todo.domain.TodoDTO;
import todo.util.ConnectionProvider;

public class TodoDAO {

	// 싱글톤
	// 1. 생성자 - private
	private TodoDAO() {

	}

	// 2. 내부에서 TodoDAO 인스턴스 생성 > private static
	private static TodoDAO dao = new TodoDAO();

	// 3. 외부에서 TodoDAO의 참조값을 얻어 갈 수 있는 메소드 >> public static
	public static TodoDAO getInstance() {
		return dao;
	}

	// TodoDTO 리스트를 반환하는 메소드

	
	// rs >>TodoDTO 생성 >> 반환 매번 작성 할 필요없이 
	private TodoDTO makeTodoDTO(ResultSet rs) throws SQLException {
		
		return new TodoDTO(
				rs.getInt("tno"),
				rs.getString("todo"),
				rs.getString("duedate"),
				rs.getBoolean("finished"));
		
	}
	public List<TodoDTO> selectByAll(Connection conn) {

		// RequestTodo 데이터를 받아서 insert 처리

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<TodoDTO> list = null;

		// SQL
		String sql = "select * from tbl_todo";

		try {
			// PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// set xx
			// 결과 받기
			// ResultSet
			rs = pstmt.executeQuery();

			list = new ArrayList<TodoDTO>();

			// List<TodoDTO> 에 저장 반환
			while (rs.next()) {
//				int tno = rs.getInt("tno");
//				String todo = rs.getString("todo");
//				String duedate = rs.getString("duedate");
//				boolean finished = rs.getBoolean("finished");
//
//				TodoDTO dto = new TodoDTO(tno, todo, duedate, finished);
				list.add(makeTodoDTO(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();

				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return list;

	}

	// tno 값을 받아서 해당 Todo 정보(TodoDTO) 을 반환하는 메소
	public TodoDTO selectByTno(Connection conn, int tno) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TodoDTO todo = null;

		// select Sql
		String sql = "select * from tbl_todo where tno = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			// set
			pstmt.setInt(1, tno);

			// rs
			rs = pstmt.executeQuery();

			// if : 결과 행이 0 또는 1 일 때 tno가 pk이기 때문에

			if (rs.next()) {
				todo = makeTodoDTO(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return todo;
	}

	public int insertTodo(Connection conn, RequestTodo todo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "INSERT INTO tbl_todo (todo, duedate) VALUES(?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todo.getTodo());
			pstmt.setString(2, todo.getDuedate());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	// TodoDTO 전달 받고
	public int updateByTno(Connection conn, TodoDTO todo) {

		PreparedStatement pstmt = null;

		int result = 0;

		// update sql
		String sql = "update tbl_todo set todo=?, duedate = ? , finished=? where tno = ?";
		try {
			pstmt = conn.prepareStatement(sql);

			// set
			pstmt.setString(1, todo.getTodo());
			pstmt.setString(2, todo.getDuedate());
			pstmt.setBoolean(3, todo.isFinished()); // rs.getBoolean("finished")
			pstmt.setInt(4, todo.getTno());

			// result

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}

	public int deleteByTno(Connection conn, int tno) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = "delete from tbl_todo where tno=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, tno);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void main(String[] args) throws SQLException {
		TodoDAO dao = TodoDAO.getInstance();
		Connection conn = ConnectionProvider.getConnection();

		
		//delete test
//		dao.deleteByTno(conn, 2);
//		System.out.println("삭제 완료");
		// update test
//		dao.updateByTno(conn, new TodoDTO(2, "청소 후 휴식", "2023-05-01", true));
//		System.out.println("수정 완료 ...");
		// selectbytno test
//		TodoDTO todo = dao.selectByTno(conn, 5);
//		System.out.println(todo);

		// insert test
//		dao.insertTodo(conn, new RequestTodo("회의", "2023-05-03"));



		// selectbyall test
		List<TodoDTO> list = dao.selectByAll(conn);
		for(TodoDTO todo : list) {
			System.out.println(todo);
		}
			conn.close();
	}

}
