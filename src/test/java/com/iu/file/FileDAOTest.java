package com.iu.file;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.iu.s6.AbstractTest;

public class FileDAOTest extends AbstractTest{

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
	public void setWriteTest()throws Exception{
		FileDTO fileDTO = new FileDTO();
		
		fileDTO.setNum(1);
		fileDTO.setFname("f1");
		fileDTO.setOname("f1");
		FileDTO fileDTO2 = new FileDTO();
		fileDTO2.setFnum(51);
		
		fileDTO2.setNum(1);
		fileDTO2.setFname("f2");
		fileDTO2.setOname("f2");
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		files.add(fileDTO);
		files.add(fileDTO2);
		int result = fileDAO.setWrite(files);
		System.out.println("Test Done");
		//assertEquals(1, result);
	}
	
	//@Test
	public void setUpdate()throws Exception{
		int result = fileDAO.setUpdate(fileDTO);
		assertEquals(0, result);
	}
	
	//@Test
	public void setDelete()throws Exception{
		int result = fileDAO.setDelete(0);
	}
}