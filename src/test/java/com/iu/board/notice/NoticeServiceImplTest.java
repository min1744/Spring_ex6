package com.iu.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s6.AbstractTest;
import com.iu.util.PageMaker;

public class NoticeServiceImplTest extends AbstractTest {

	@Inject
	private NoticeService noticeService;
	
	//@Test
	public void test() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setContents("contents");
		boardDTO.setTitle("title");
		boardDTO.setWriter("writer");
		//int result = noticeService.setWrite(boardDTO, multipartFiles, session);
		//assertNotEquals(0, result);
	}
}