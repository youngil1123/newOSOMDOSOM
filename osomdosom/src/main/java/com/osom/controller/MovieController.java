package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.Board;
import com.osom.dto.MovieInfo;
import com.osom.service.BoardService;
import com.osom.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieservice;
	@Autowired
	BoardService boardservice;
	
	@RequestMapping("/review/moviereview")
	public String bookreview(String movieCd, Model model) {
		//책 하나 리뷰 보는 페이지로 이동(책 정보 + 리뷰정보를 가지고)
		
		MovieInfo movie= null;
		List<MovieInfo> moviereview = new ArrayList<MovieInfo>();
		try {
			movie = movieservice.get(movieCd);
			System.out.println(movie);
			moviereview = movieservice.getonemoviereview(movieCd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("movie", movie);
		model.addAttribute("moviereview", moviereview);
		
		return "review/moviereview";
		
	}
}