package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Board;
import com.osom.dto.BookInfo;
import com.osom.dto.Mbti;
import com.osom.dto.Member_tbl;
import com.osom.dto.MovieInfo;
import com.osom.dto.TheaterInfo;
import com.osom.service.BoardService;
import com.osom.service.BookService;
import com.osom.service.MbtiService;
import com.osom.service.MovieService;
import com.osom.service.TheaterService;

@Controller
public class MediaController {

	@Autowired
	TheaterService theaterService;

	@Autowired
	MovieService movieService;

	@Autowired
	BookService service;

	@Autowired
	BoardService boardservice;
	@Autowired
	MbtiService mbtiservice;

	@RequestMapping("/mediamain") 
		
	public String mediamain(Model model) {

		// 도서 순위 5
		List<Board> blist = new ArrayList<Board>();
		blist = boardservice.getTop5("도서");
		List<Mbti> books = new ArrayList<Mbti>();
		for (Board o : blist) {
			// conno 가지고 정보 가져오기.
			Mbti m = null;
			int con_no = o.getCon_no();
			m = mbtiservice.getconByconnoBook(con_no);
			m.setConStar_rate(o.getConStar_rate());
			m.setCon_no(con_no);
			books.add(m);
		}
		model.addAttribute("booktop5", books);

		// 영화 순위 5
		List<Board> mlist = new ArrayList<Board>();
		mlist = boardservice.getTop5("영화");
		List<Mbti> movies = new ArrayList<Mbti>();
		for (Board o : mlist) {
			// conno 가지고 정보 가져오기.
			Mbti m = null;
			int con_no = o.getCon_no();
			m = mbtiservice.getconByconnoMovie(con_no);
			m.setConStar_rate(o.getConStar_rate());
			m.setCon_no(con_no);
			movies.add(m);
		}
		model.addAttribute("movietop5", movies);

		// 연극 순위 5
		List<Board> tlist = new ArrayList<Board>();
		tlist = boardservice.getTop5("연극");
		List<Mbti> theaters = new ArrayList<Mbti>();
		for (Board o : tlist) {
			// conno 가지고 정보 가져오기.
			Mbti m = null;
			int con_no = o.getCon_no();
			m = mbtiservice.getconByconnoTheater(con_no);
			m.setConStar_rate(o.getConStar_rate());
			m.setCon_no(con_no);
			theaters.add(m);
		}
		model.addAttribute("theatertop5", theaters);
		System.out.println(books);
		System.out.println(movies);
		System.out.println(theaters);

		model.addAttribute("top", "mediamain");
		return "/board/mediamain";
	}

	@RequestMapping("/moviedetail")
	public String searchmylist(Model model, HttpSession session) throws Exception {
		List<Board> list = null;
		Member_tbl member = new Member_tbl();
		member = (Member_tbl) session.getAttribute("logincust");

		if (member != null) {
			int mem_no = member.getMem_no();
			list = boardservice.searchmylist(mem_no);
		}

		model.addAttribute("searchmylist", list);

		return "board/moviedetail";
	}

	@RequestMapping("/musical")
	public String musical(Model model, String genrenm) {

		List<TheaterInfo> theater = new ArrayList<TheaterInfo>();

		try {
			theater = theaterService.gettheaterreview("뮤지컬");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		model.addAttribute("theaterreviews", theater);
		model.addAttribute("top", "theater");

		model.addAttribute("top", "musical");
		return "/board/musical";
	}

	// 책
	@RequestMapping("/book")
	public String book(Model model) {
		List<BookInfo> objs = new ArrayList<BookInfo>();
		try {
			objs = service.getbookreview();
			model.addAttribute("bookreviews", objs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("top", "book");
		return "/board/book";
	}

	// 연극,뮤지컬
	@RequestMapping("/theater")
	public String getposter(Model model, String genrenm) {

		List<TheaterInfo> theater = new ArrayList<TheaterInfo>();

		try {
			theater = theaterService.gettheaterreview("연극");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		model.addAttribute("theaterreviews", theater);
		model.addAttribute("top", "theater");
		return "/board/theater";
	}

	// 영화
	@RequestMapping("/movie")
	public String getmovie(Model model) {

		List<MovieInfo> movie = new ArrayList<MovieInfo>();

		try {
			movie = movieService.getmoviereview();
			model.addAttribute("moviereviews", movie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("top", "movie");
		return "/board/movie";
	}

}
