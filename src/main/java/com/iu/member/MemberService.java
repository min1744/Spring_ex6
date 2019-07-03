package com.iu.member;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.memberfile.MemberfileDAO;
import com.iu.memberfile.MemberfileVO;
import com.iu.util.FileSaver;

@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private MemberfileDAO memberfileDAO;
	@Inject
	private FileSaver fileSaver;
	
	public int setWrite(MemberVO memberVO, MultipartFile multipartFile, HttpSession session) throws Exception{
		//1. 저장 경로
		String realPath = session.getServletContext().getRealPath("/resources/member_upload");
		System.out.println("realPath : "+realPath);
		String fileSystemName = fileSaver.saveFile(realPath, multipartFile);
		MemberfileVO memberfileVO = new MemberfileVO();
		memberfileVO.setId(memberVO.getId());
		memberfileVO.setFname(fileSystemName);
		memberfileVO.setOname(multipartFile.getOriginalFilename());
		int result = memberDAO.setWrite(memberVO);
		result = memberfileDAO.setWrite(memberfileVO);
		if(result < 1) {
			System.out.println("memberfile write fail");
		}
		
		return result;
	}
	
	public MemberVO getSelect(MemberVO memberVO) throws Exception{
		memberVO = memberDAO.getSelect(memberVO);
		
		return memberVO;
	}
}