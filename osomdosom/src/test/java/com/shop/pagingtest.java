package com.shop;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Board;
import com.osom.dto.Paging;
import com.osom.service.Member_tblService;



@SpringBootTest
class pagingtest {

	@Autowired
	Member_tblService service;
	@Test
    void contextLoads() {
		List<Board> list = null;
    	Paging p = null;
    	p.setMem_no(2);
    	try {
			p.setTotalRecord(service.totalRecord(2));
			p.setOnePageRecord(15);
			p.setSelectRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(p);
			list=service.boardPageSelect(p);
			for(Board b : list) {
				System.out.println("------------");
				System.out.println(b);
			}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}