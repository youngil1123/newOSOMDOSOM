package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.Board;
import com.osom.dto.Like_list;
import com.osom.dto.Member_tbl;
import com.osom.dto.Paging;
import com.osom.dto.TheaterInfo;
import com.osom.service.BoardService;
import com.osom.service.LikeService;
import com.osom.service.TheaterService;

@Controller
public class TheaterController {

	@Autowired
	TheaterService theaterservice;
	@Autowired
	BoardService boardservice;
	@Autowired
	LikeService likeservice;
	@RequestMapping("/review/theaterreview")
	public String theaterreview(String mt20id, Model model,Paging p,HttpSession session) {
		//뮤지컬 하나 리뷰 보는 페이지로 이동(뮤지컬 정보 + 리뷰정보를 가지고)
		TheaterInfo theater = null;
		List<TheaterInfo> theaterreview = new ArrayList<TheaterInfo>();
		Member_tbl m = (Member_tbl)session.getAttribute("logincust");
		int result = 0;
		Like_list l = new Like_list();
		try {
			theater = theaterservice.get(mt20id);
			p.setMt20id(mt20id);
			p.setGenrenm("연극");
			p.setTotalRecord(theaterservice.totalRecord(p));
			p.setStartRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(theater);
			theaterreview = theaterservice.getonetheaterreview(mt20id);
			//찜 상태 체크..
			l.setCon_no(theater.getCon_no());
			if(m!=null) {
				l.setMem_no(m.getMem_no());
				result = likeservice.likeStateCheck(l);
			}
			if(result !=0) {
				//찜 되어있는 상태이면 result=1일것
				model.addAttribute("likestate", result);
			}else {
				//찜 되어있는 상태이면 result=0일것
				model.addAttribute("likestate", result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("theater", theater);
		model.addAttribute("theaterreview", theaterreview);
		model.addAttribute("p", p);
		model.addAttribute("logincust", session.getAttribute("logincust"));
		return "review/theaterreview";
		
	}
	
	@RequestMapping("/review/musicalreview")
	public String musicalreview(String mt20id, Model model,Paging p,HttpSession session) {
		//뮤지컬 하나 리뷰 보는 페이지로 이동(뮤지컬 정보 + 리뷰정보를 가지고)
		TheaterInfo theater = null;
		List<TheaterInfo> theaterreview = new ArrayList<TheaterInfo>();
		Member_tbl m = (Member_tbl)session.getAttribute("logincust");
		int result = 0;
		Like_list l = new Like_list();
		try {
			theater = theaterservice.get(mt20id);
			p.setMt20id(mt20id);
			p.setGenrenm("뮤지컬");
			p.setTotalRecord(theaterservice.totalRecord(p));
			p.setStartRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(theater);
			theaterreview = theaterservice.getonetheaterreview(mt20id);
			//찜 상태 체크..
			l.setCon_no(theater.getCon_no());
			if(m!=null) {
				l.setMem_no(m.getMem_no());
				result = likeservice.likeStateCheck(l);
			}
			if(result !=0) {
				//찜 되어있는 상태이면 result=1일것
				model.addAttribute("likestate", result);
			}else {
				//찜 되어있는 상태이면 result=0일것
				model.addAttribute("likestate", result);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("theater", theater);
		model.addAttribute("theaterreview", theaterreview);
		model.addAttribute("p", p);
		model.addAttribute("logincust", session.getAttribute("logincust"));
		
		return "review/theaterreview";
		
	}
}
