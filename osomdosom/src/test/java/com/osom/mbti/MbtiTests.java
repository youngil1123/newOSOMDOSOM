package com.osom.mbti;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Mbti;
import com.osom.service.MbtiService;

@SpringBootTest
class MbtiTests {

	@Autowired
	MbtiService mservice;

	@Test
	void contextLoads() {
		int mbtimemno = mservice.countmbtimemno("isfp");
		System.out.println(mbtimemno);

		List<Mbti> conlist = new ArrayList<Mbti>();
		conlist = mservice.getconnoAndcountmem("isfp");

		List<Mbti> contents = new ArrayList<Mbti>();
		for (Mbti o : conlist) {
			int con_no = o.getCon_no();
			System.out.println(con_no);
			String congenre = mservice.getcongenreByconno(con_no);
			// 장르별로 컨텐츠 조회
			Mbti m = null;
			switch (congenre) {
			case "영화":
				m = mservice.getconByconnoMovie(con_no);
				m.setCongenre("영화");
				contents.add(m);
				System.out.println("영화추가");
				break;
			case "도서":
				m = mservice.getconByconnoBook(con_no);
				m.setCongenre("도서");
				contents.add(m);
				System.out.println("도서추가");
				break;
			case "연극":
				m = mservice.getconByconnoTheater(con_no);
				m.setCongenre("연극");
				contents.add(m);
				System.out.println("연극추가");
				break;
			case "뮤지컬":
				m = mservice.getconByconnoTheater(con_no);
				m.setCongenre("뮤지컬");
				contents.add(m);
				System.out.println("뮤지컬추가");
				break;
			default:
				break;
			}

		}
		for (Mbti s : contents) {
			System.out.println("-------------------");
			System.out.println(s);
		}
	}

}