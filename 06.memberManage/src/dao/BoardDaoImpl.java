package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Board;

public class BoardDaoImpl implements BoardDao{

	@Override
	public void insert(Board board) {
	      Connection connection = null;
	      PreparedStatement pStatement = null;
	      
	      try {
	         connection = JDBCUtil.getConnection();
	         pStatement = connection.prepareStatement(Sql.BOARD_INSERT_SQL);
	         //인서트문 가져와서 추가
	         
	         pStatement.setString(1, board.getSubject());
	         pStatement.setString(2, board.getContent());
	         pStatement.setInt(3, board.getCnt());
	         pStatement.setString(4, board.getId());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

//	@Override
//	public void update(Customer customer) {
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.DEPT_UPDATE_SQL);
//			//update memo set name = ?, age = ? where memoid = ?
//			pStatement.setString(1, customer.getName()); // ?값 셋팅 
//			pStatement.setInt(2, customer.getAge()); // ?값 셋팅  
//			pStatement.setInt(3, customer.getMemoid()); // ?값 셋팅  
//			//insert, delete, update에 사용
//			pStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//			
//		} finally {
//			
//			JDBCUtil.close(null, pStatement, connection);
//		}
//		
//	}
//
//	@Override
//	public void delete(int customerseq) {
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_DELETE_SQL);
//			//delete from memo where memoid = ?
//			pStatement.setInt(1, memoid); // ?값 셋팅 
//			//insert, delete, update에 사용
//			pStatement.executeUpdate();
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//			
//		} finally {
//			
//			JDBCUtil.close(null, pStatement, connection);
//		}
//		
//	}
//
	@Override
	public List<Board> selectAll() {
		List<Board> boardList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_SELECT_ALL_SQL);
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Board board = new Board();
				
				board.setNo(resultSet.getInt("no"));
				board.setSubject(resultSet.getString("subject"));
				board.setSubject(resultSet.getString("content"));
				board.setWdate(resultSet.getString("wdate"));
				board.setCnt(resultSet.getInt("cnt"));
				board.setId(resultSet.getString("id"));
				
				boardList.add(board);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return boardList;
	}
//
//	@Override
//	public Customer selectByCustomerseq(int customerseq) {
//		Customer customer = null;
//		
//		Connection connection = null;
//		PreparedStatement pStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = JDBCUtil.getConnection();
//			pStatement = connection.prepareStatement(Sql.MEMO_SELECT_BY_MEMOID_SQL);
//			
//			//select memoid, name, age from memo where memoid=?
//			pStatement.setInt(1, memoid);
//			resultSet = pStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				
//				Customer customer = new Customer();
//				
//				customer.setMemoid(resultSet.getInt("memoid"));
//				customer.setName(resultSet.getString("name"));
//				customer.setAge(resultSet.getInt("age"));
//				
//			}
//			
//		} catch (Exception e) {
//			e.getStackTrace();
//		} finally {
//			JDBCUtil.close(resultSet, pStatement, connection);
//		}
//		
//		return customer;
//	}
	
}
