package com.iu.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.PageMaker;


@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		//HashMap<String, Object> map = new HashMap<String, Object>();
		//map.put("boardDTO", boardDTO);
		//map.put("pnum", 0);
		return sqlSession.insert(NAMESPACE+"noticeWrite", boardDTO);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"noticeUpdate", boardDTO);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", num);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"noticeList", pageMaker);
	}

	@Override
	public int getTotalCount(PageMaker pageMaker) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"totalCount", pageMaker);
	}
}