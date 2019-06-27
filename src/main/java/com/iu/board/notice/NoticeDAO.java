package com.iu.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.DBConnector;

@Repository
public class NoticeDAO implements BoardDAO {
	@Inject
	private DBConnector dbConnector;

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		String sql = "INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getWriter());
		st.setString(3, boardDTO.getContents());
		int result = st.executeUpdate();
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM (SELECT ROWNUM R, N.* FROM (SELECT * FROM NOTICE ORDER BY NUM DESC) N) WHERE R BETWEEN ? AND ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, 1);
		st.setInt(2, 10);
		ResultSet rs = st.executeQuery();
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			ar.add(boardDTO);
		}
		rs.close();
		st.close();
		con.close();

		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM NOTICE WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		ResultSet rs = st.executeQuery();
		BoardDTO boardDTO = null;
		if(rs.next()) {
			boardDTO = new BoardDTO();
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setHit(rs.getInt("hit"));
			boardDTO.setNum(rs.getInt("num"));
			boardDTO.setReg_date(rs.getDate("reg_date"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
		}
		rs.close();
		st.close();
		con.close();

		return boardDTO;
	}
}