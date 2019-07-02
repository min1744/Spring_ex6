package com.iu.board.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.member.MemberDAO;
import com.iu.member.MemberVO;
import com.iu.memberfile.MemberfileDAO;
import com.iu.memberfile.MemberfileVO;
import com.iu.s6.AbstractTest;

public class MemberDAOTest extends AbstractTest {

	@Inject
	private MemberDAO memberDAO;
	@Inject
	private MemberfileDAO memberfileDAO;
	
	//@Test
	public void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("iu");
		memberVO.setPw("iu");
		//memberVO.setName("iu");
		//memberVO.setEmail("iu@iu.com");
		//int result = memberDAO.setWrite(memberVO);
		memberVO = memberDAO.getSelect(memberVO);
		assertNotNull(memberVO);
	}
	
	@Test
	public void testFile() throws Exception{
		MemberfileVO memberfileVO = new MemberfileVO();
		memberfileVO.setId("iu");
		memberfileVO.setFname("fname");
		memberfileVO.setOname("oname");
		int result = memberfileDAO.setWrite(memberfileVO);
		assertEquals(1, result);
	}
}