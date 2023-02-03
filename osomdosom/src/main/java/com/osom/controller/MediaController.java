package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.BookInfo;
import com.osom.dto.MovieInfo;
import com.osom.dto.TheaterInfo;
import com.osom.service.BookService;
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
	
	


	@RequestMapping("/mediamain")
    public String mediamain(Model model) {
		
		model.addAttribute("top", "mediamain");
        return "/board/mediamain";
    }
	@RequestMapping("/moviedetail")
    public String moviedetail(Model model) {
		
		model.addAttribute("top", "moviedetail");
        return "/board/moviedetail";
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
	//책
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
	
	//연극,뮤지컬
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
	//영화
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
