package com.iu.board.notice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class NoticeService implements BoardService {
	
	@Inject
	private FileSaver fileSaver;
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		//파일을 HDD에 저장
		int num = noticeDAO.getNum();
		boardDTO.setNum(num);
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		for(MultipartFile multipartFile:multipartFiles) {
			String fileSystemName = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fileSystemName);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			files.add(fileDTO);
		}
		
		for(FileDTO fileDTO : files) {
			fileDAO.setWrite(fileDTO);
		}
		
		return noticeDAO.setWrite(boardDTO);
	}

	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(num);
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		pageMaker.makeRow();
		int totalCount = noticeDAO.getTotalCount(pageMaker);
		//페이징 처리 계산
		pageMaker.makePage(totalCount);
		
		return noticeDAO.getList(pageMaker);
	}
}