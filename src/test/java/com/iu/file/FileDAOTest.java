package com.iu.file;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.iu.s6.AbstractTest;

public class FileDAOTest extends AbstractTest {

	@Inject
	private FileDAO fileDAO;
	private FileDTO fileDTO;
	
	@Before
	public void ready() {
		fileDTO = new FileDTO();
		fileDTO.setNum(1);
		fileDTO.setFname("fname");
		fileDTO.setOname("oname");
	}
	
	@Test
	public void setWriteTest() throws Exception{
		int result = fileDAO.setWrite(fileDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setUpdateTest() throws Exception{
		int result = fileDAO.setUpdate(fileDTO);
		assertEquals(0, result);
	}
	
	@Test
	public void setDeleteTest() throws Exception{
		int result = fileDAO.setDelete(0);
		assertEquals(0, result);
	}
}