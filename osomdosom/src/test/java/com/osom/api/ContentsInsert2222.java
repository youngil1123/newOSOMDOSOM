package com.osom.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Contents;
import com.osom.service.BookService;
import com.osom.service.ContentsService;
import com.osom.service.MovieService;
import com.osom.service.TheaterService;

@SpringBootTest
class ContentsInsert2222 {
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
		List<String> theatercds = new ArrayList<String>();
		List<String> musicalcds = new ArrayList<String>();
		try {
			theatercds = theaterservice.getcd("연극");
			musicalcds = theaterservice.getcd("뮤지컬");
			for(String theatercd : theatercds) {
				Contents content = new Contents();
				content.setCon_genre("연극");
				content.setCon_cd(theatercd);
				contentsservice.register(content);
			}
			System.out.println("연극삽입완료");
			for(String musicalcd : musicalcds) {
				Contents content = new Contents();
				content.setCon_genre("뮤지컬");
				content.setCon_cd(musicalcd);
				contentsservice.register(content);
			}
			System.out.println("뮤지컬삽입완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*=====================영화insert
		List<String> movies = new ArrayList<String>();
		try {
			movies = movieservice.getmoviecd();
			for(String movieCd : movies) {
				Contents content = new Contents();
				content.setCon_genre("영화");
				content.setCon_cd(movieCd);
				contentsservice.register(content);
			}
			System.out.println("영화 콘텐츠테이블에 추가");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*====================도서insert
		List<Integer> books = new ArrayList<Integer>();
		try {
			books = bookservice.getbookno();
			for (int book_no : books) {
				Contents content = new Contents();
				content.setCon_genre("도서");
				content.setCon_cd(""+book_no);
				
				contentsservice.register(content);
			}
			System.out.println("도서 콘텐츠테이블에 추가");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
