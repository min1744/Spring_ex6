package com.iu.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;

@Service
public class NoticeService implements BoardService {

	@Inject
	private NoticeDAO noticeDAO;
	
	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		int result = noticeDAO.setWrite(boardDTO);
		
		return result;
	}

	@Override
	public List<BoardDTO> getList() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		BoardDTO boardDTO = noticeDAO.getSelect(num);

		return boardDTO;
	}
}