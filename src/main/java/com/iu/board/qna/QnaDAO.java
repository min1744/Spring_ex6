package com.iu.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.PageMaker;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private String mapper = "QnaMappger.";

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(mapper+"qnaWrite", boardDTO);
		
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		List<BoardDTO> ar = sqlSession.selectList(mapper+"qnaList");
		
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		BoardDTO boardDTO = sqlSession.selectOne(mapper+"qnaSelect", num);
		
		return boardDTO;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.update(mapper+"qnaUpdate", boardDTO);
		
		return result;
	}

	@Override
	public int setDelete(int num) throws Exception {
		int result = sqlSession.delete(mapper+"qnaDelete", num);
		
		return result;
	}
}