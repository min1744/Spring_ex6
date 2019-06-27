package com.iu.board;

import java.util.List;

public interface BoardDAO {
	//글 등록
	public int setWrite(BoardDTO boardDTO) throws Exception;
	
	//글 리스트
	public List<BoardDTO> getList() throws Exception;
	
	//글 하나
	public BoardDTO getSelect(int num) throws Exception;
}