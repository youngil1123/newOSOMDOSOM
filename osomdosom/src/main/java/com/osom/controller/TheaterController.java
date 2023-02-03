package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.Board;
import com.osom.dto.TheaterInfo;
import com.osom.service.BoardService;
import com.osom.service.TheaterService;

@Controller
public class TheaterController {

	@Autowired
	TheaterService theaterservice;
	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/review/theaterreview")
	public String theaterreview(String mt20id, Model model) {
		//뮤지컬 하나 리뷰 보는 페이지로 이동(뮤지컬 정보 + 리뷰정보를 가지고)
		TheaterInfo theater = null;
		List<TheaterInfo> theaterreview = new ArrayList<TheaterInfo>();
		try {
			theater = theaterservice.get(mt20id);
			System.out.println(theater);
			theaterreview = theaterservice.getonetheaterreview(mt20id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("theater", theater);
		model.addAttribute("theaterreview", theaterreview);
		
		return "review/theaterreview";
		
	}
	
	@RequestMapping("/review/musicalreview")
	public String musicalreview(String mt20id, Model model) {
		//뮤지컬 하나 리뷰 보는 페이지로 이동(뮤지컬 정보 + 리뷰정보를 가지고)
		TheaterInfo theater = null;
		List<TheaterInfo> theaterreview = new ArrayList<TheaterInfo>();
		try {
			theater = theaterservice.get(mt20id);
			System.out.println(theater);
			theaterreview = theaterservice.getonetheaterreview(mt20id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("theater", theater);
		model.addAttribute("theaterreview", theaterreview);
		
		return "review/theaterreview";
		
	}
}
