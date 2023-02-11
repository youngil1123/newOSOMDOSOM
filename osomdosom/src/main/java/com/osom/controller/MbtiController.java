package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.Mbti;
import com.osom.service.MbtiService;

@Controller
public class MbtiController {

	@Autowired
	MbtiService mservice;

	@RequestMapping("/mbtiex")
    public String mbtiex(Model model, String mbti) {
		//mbti 하나 페이지로 이동
		System.out.println(mbti);
		int mbtimemno = mservice.countmbtimemno(mbti);
		model.addAttribute("mbtimemno", mbtimemno); // 현재 같은 mbti 회원수
		
		List<Mbti> conlist = new ArrayList<Mbti>();
		conlist = mservice.getconnoAndcountmem(mbti); // mbti 별로 리뷰가 많은 컨텐츠 상위 10개의 컨텐츠 넘버  가져오기

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
		model.addAttribute("contents", contents);
		System.out.println(contents);
		model.addAttribute("top", "mbtiex");
		model.addAttribute("mbti", mbti);
        return "/mbti/mbtiex";
    }
	
	@RequestMapping("/mbtimain")
    public String mbtimain(Model model) {
		model.addAttribute("top", "mbtimain");
		
        return "/mbti/mbtimain";
    }
}
