package com.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Member_tbl;
import com.osom.service.Member_tblService;



@SpringBootTest
class IdCheckTests {

    @Autowired
    Member_tblService service;

    @Test
	public void memberIdChk() throws Exception{
		String id = "admin";	// 존재하는 아이디
		String id2 = "test123";	// 존재하지 않는 아이디
		
		/*
		 * service. overlappedID (id); service. overlappedID (id2);
		 */
		
	}
}