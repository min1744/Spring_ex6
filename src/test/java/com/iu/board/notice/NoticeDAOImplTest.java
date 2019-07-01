package com.iu.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;
import com.iu.util.PageMaker;

public class NoticeDAOImplTest extends AbstractTest {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void getCount() throws Exception{
		PageMaker pageMaker = new PageMaker();
		pageMaker.setKind("1");
		pageMaker.setSearch("tt");
		int result = noticeDAO.getTotalCount(pageMaker);
		assertEquals(1, result);
	}
	
	//@Test
	public void selectList()throws Exception{
		/*
		 * List<BoardDTO> ar = noticeDAO.getList(); assertEquals(3, ar.size());
		 */
		
	}
	
	//@Test
	public void selectOne()throws Exception{
		BoardDTO boardDTO = noticeDAO.getSelect(222);
		//System.out.println(boardDTO.getTitle());
		assertNotNull(boardDTO);
	}
	
	//@Test
	public void update()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(3);
		noticeDTO.setTitle("change");
		noticeDTO.setContents("change");
		int result = noticeDAO.setUpdate(noticeDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void delete() throws Exception{
		int result = noticeDAO.setDelete(111);
		assertEquals(0, result);
	}
	
	//@Test
	public void test() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setWriter("mmm");
		noticeDTO.setTitle("tttt");
		noticeDTO.setContents("cccc");
		int result = noticeDAO.setWrite(noticeDTO);
		assertEquals(1, result);
	}
}