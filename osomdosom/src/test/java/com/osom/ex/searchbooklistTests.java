package com.osom.ex;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.BookInfo;
import com.osom.service.BookService;



@SpringBootTest
class searchbooklistTests {

    @Autowired
    BookService service;

    @Test
    void contextLoads() {
    	List<BookInfo> objs = new ArrayList<BookInfo>();
    	try {
			objs = service.searchbooklist("달러구트");
			for(BookInfo obj : objs) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }

}