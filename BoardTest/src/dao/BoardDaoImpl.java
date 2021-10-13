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
	         
	         pStatement.setString(1, board.getSubject());
	         pStatement.setString(2, board.getContent());
	         pStatement.setString(3, board.getId());
	         
	         pStatement.executeUpdate(); 
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         JDBCUtil.close(null, pStatement, connection); 
	      }
	   }

	@Override
	public void update(Board board) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_UPDATE_SQL);
			//update bbs set subject = ?, content = ? where no = ?
			pStatement.setString(1, board.getSubject()); // ?값 셋팅 
			pStatement.setString(2, board.getContent()); // ?값 셋팅  
			pStatement.setInt(3, board.getNo()); // ?값 셋팅  
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

	@Override
	public void delete(int boardNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_DELETE_SQL);
			//delete from bbs where no = ?
			pStatement.setInt(1, boardNo); // ?값 셋팅 
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}

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
				board.setContent(resultSet.getString("content"));
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

	@Override
	public List<Board> selectBySubject(String searchValue) {
		List<Board> boardList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_SELECT_BY_SUBJECT_SQL);
			pStatement.setString(1, '%'+searchValue+'%');
			resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				
				Board board = new Board();
				
				board.setNo(resultSet.getInt("no"));
				board.setSubject(resultSet.getString("subject"));
				board.setContent(resultSet.getString("content"));
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

	@Override
	public Board selectByNo(int no) {
		Board board = null;
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_SELECT_BY_NO_SQL);
			
			pStatement.setInt(1, no);
			resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				
				board = new Board();
				
				board.setNo(resultSet.getInt("no"));
				board.setSubject(resultSet.getString("subject"));
				board.setContent(resultSet.getString("content"));
				board.setWdate(resultSet.getString("wdate"));
				board.setCnt(resultSet.getInt("cnt"));
				board.setId(resultSet.getString("id"));
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(resultSet, pStatement, connection);
		}
		
		return board;
	}

	@Override
	public void cntUpdate(Board board) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		
		try {
			connection = JDBCUtil.getConnection();
			pStatement = connection.prepareStatement(Sql.BOARD_CNT_UPDATE_SQL);
			//update bbs set cnt = ? where no = ?
			pStatement.setInt(1, board.getCnt()); // ?값 셋팅  
			pStatement.setInt(2, board.getNo()); // ?값 셋팅  
			
			pStatement.executeUpdate();
			
		} catch (Exception e) {
			e.getStackTrace();
			
		} finally {
			
			JDBCUtil.close(null, pStatement, connection);
		}
		
	}
	
}
