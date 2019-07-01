package com.iu.file;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	public void setWrite() throws Exception{
		
	}
	
	public void setUpdate() throws Exception{
		
	}
	
	public void setDelete() throws Exception{
		
	}
	
	public void getSelect() throws Exception{
		
	}
	
	public void getList() throws Exception{
		
	}
}