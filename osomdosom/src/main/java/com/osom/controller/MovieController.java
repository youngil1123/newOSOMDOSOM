package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
import com.osom.dto.Board;
=======
import com.osom.dto.Like_list;
import com.osom.dto.Member_tbl;
>>>>>>> branch 'main' of https://github.com/youngil1123/newOSOMDOSOM.git
import com.osom.dto.MovieInfo;
import com.osom.dto.Paging;
import com.osom.service.BoardService;
import com.osom.service.LikeService;
import com.osom.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieservice;
	@Autowired
	BoardService boardservice;
	@Autowired
	LikeService likeservice;
	@RequestMapping("/review/moviereview")
	public String moviereview(String movieCd, Model model,Paging p,HttpSession session) {
		//영화 하나 리뷰 보는 페이지로 이동(영화 정보 + 리뷰정보를 가지고)
		
		MovieInfo movie= null;
		Board con_no = null;
		List<MovieInfo> moviereview = new ArrayList<MovieInfo>();
		Member_tbl m = (Member_tbl)session.getAttribute("logincust");
		int result = 0;
		Like_list l = new Like_list();
		try {
			movie = movieservice.get(movieCd);
			p.setTotalRecord(movieservice.totalRecord(movieCd));
			p.setMovieCd(movieCd);
			p.setStartRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(movie);
			System.out.println(p);
			moviereview = movieservice.boardPageSelect(p);

			boardservice.getavgstar_rate(con_no);

			//찜 상태 체크..
			l.setCon_no(movie.getCon_no());
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
		model.addAttribute("movie", movie);
		model.addAttribute("moviereview", moviereview);
		model.addAttribute("p", p);

		model.addAttribute("con_no",con_no);

		model.addAttribute("logincust", session.getAttribute("logincust"));
		

		return "review/moviereview";
		
	}
}
