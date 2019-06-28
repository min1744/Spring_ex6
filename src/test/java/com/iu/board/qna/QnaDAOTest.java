package com.iu.board.qna;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s6.AbstractTest;

public class QnaDAOTest extends AbstractTest {

	@Inject
	private QnaDAO qnaDAO;
	
	@Test
	public void insert() throws Exception {
		QnaDTO boardDTO = new QnaDTO();
		boardDTO.setTitle("t2");
		boardDTO.setWriter("w2");
		boardDTO.setContents("c2");
		int result = qnaDAO.setWrite(boardDTO);
		assertNotEquals(0, result);
	}
}