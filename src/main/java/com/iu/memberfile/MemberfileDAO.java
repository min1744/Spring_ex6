package com.iu.memberfile;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberfileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "MemberfileMapper.";
	
	public int setWrite(MemberfileVO memberfileVO) throws Exception{
		int result = sqlSession.insert(NAMESPACE+"setWrite", memberfileVO);
		
		return result;
	}
	
	public MemberfileVO getSelect(String id) throws Exception{
		MemberfileVO memberfileVO = sqlSession.selectOne(NAMESPACE+"getSelect", id);
		
		return memberfileVO;
	}
}