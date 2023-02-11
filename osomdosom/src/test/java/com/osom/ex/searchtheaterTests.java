package com.osom.ex;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.BookInfo;
import com.osom.dto.TheaterInfo;
import com.osom.service.BookService;
import com.osom.service.TheaterService;



@SpringBootTest
class searchtheaterTests {

    @Autowired
    TheaterService service;

    @Test
    void contextLoads() {
    	List<TheaterInfo> objs = new ArrayList<TheaterInfo>();
    	try {
			objs = service.searchtheaterlist("수상한");
			for(TheaterInfo obj : objs) {
				System.out.println(obj);
			}
			objs = service.searchtheaterlist("시카고");
			for(TheaterInfo obj : objs) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }

}