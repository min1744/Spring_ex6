package com.iu.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "MemberMapper.";
	
	public int setWrite(MemberVO memberVO) throws Exception{
		int num = sqlSession.insert(NAMESPACE+"setWrite", memberVO);
		return num;
	}
	
	public MemberVO getSelect(MemberVO memberVO) throws Exception{
		memberVO = sqlSession.selectOne(NAMESPACE+"getSelect", memberVO);
		
		return memberVO;
	}
}