package com.osom.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.TheaterInfo;
import com.osom.service.BookService;
import com.osom.service.ContentsService;
import com.osom.service.MovieService;
import com.osom.service.TheaterService;

@SpringBootTest
class ContentsInsert {
	@Autowired
	BookService bookservice;
	@Autowired
	ContentsService contentsservice;
	@Autowired
	MovieService movieservice;
	@Autowired
	TheaterService theaterservice;

	@Test
	void contextLoads() {
		// 1. 도서에서 도서코드만 가져오기 그걸 for문 돌리면서 content테이블가서 con_no 가져오기 -> 도서테이블에 다시 넣기..
		try {
			List<String> theaters = new ArrayList<String>();
			theaters = theaterservice.getcd("연극");
			List<String> musicals = new ArrayList<String>();
			musicals = theaterservice.getcd("뮤지컬");
			for (String obj : theaters) {
				TheaterInfo theater = new TheaterInfo();
				int con_no = contentsservice.getconno(obj);
				theater.setCon_no(con_no);
				theater.setMt20id(obj);
				theaterservice.updateconno(theater);
			}
			for (String obj : musicals) {
				TheaterInfo musical = new TheaterInfo();
				int con_no = contentsservice.getconno(obj);
				musical.setCon_no(con_no);
				musical.setMt20id(obj);
				theaterservice.updateconno(musical);
			}
			
			System.out.println("완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
