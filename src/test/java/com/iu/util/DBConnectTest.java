package com.iu.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.iu.s6.AbstractTest;

public class DBConnectTest extends AbstractTest {

	//@Resource : 이름으로 찾기
	//@Autowired : 타입으로 찾기
	@Inject//타입으로 찾기
	private DriverManagerDataSource dataSource;
	
	@Test
	public void test() throws Exception {
		Connection con = dataSource.getConnection();
		assertNotNull(con);
	}
}