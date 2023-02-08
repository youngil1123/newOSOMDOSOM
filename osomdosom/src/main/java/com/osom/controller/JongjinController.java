package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Board;
import com.osom.dto.Friendship;
import com.osom.dto.Member_tbl;

import com.osom.dto.Paging;
import com.osom.service.BoardService;
import com.osom.service.FriendshipService;
import com.osom.service.Member_tblService;


@Controller
@RequestMapping("/follower")
public class JongjinController {
	
	@Autowired
	Member_tblService mservice;
	
	@Autowired
	FriendshipService fservice;
	
	@Autowired
	BoardService bservice;
	
	@RequestMapping("")
	public ModelAndView follower(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust");

		Friendship friendship = new Friendship();

		String myid = member.getMem_id(); // 로그인한 아이디
		System.out.println(myid);
		int myNo = mservice.findmem_no(myid); // 로그인 아이디의 회원번호
		System.out.println(myNo);

		try {
			List<Member_tbl> list = mservice.getfollower(myNo);
			System.out.println(list);

			for (int i = 0; i < list.size(); i++) {
				int fwNo = list.get(i).getMem_no(); // 해당번째의 회원의 회원번호
				friendship.setMem_no(fwNo);
				friendship.setMem_no2(myNo);
				Integer chk = fservice.get(friendship);
				if (chk != null) {
					list.get(i).setHeart("heart.png");
				} else {
					list.get(i).setHeart("followok.png");
				}
			}

			mv.setViewName("/follower/follower");
			mv.addObject("followerinfo", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/addFollower")
    public String addFollower() {
        return "follower/addFollower";
    }
	
	@RequestMapping("/fwBookBoard")
	public ModelAndView fwBookBoard(Integer fwNo, @RequestParam(value = "bknum", defaultValue = "1") int bknum) { //받아온 사람의 번호 , 몇번째 페이지를 보여줄건지.
		
		ModelAndView mv = new ModelAndView();
		List<Board> bklist = null;

		int onepagelist = 3; //한페이지에 2개씩 불러오자.
		
		int bkoffset = (bknum-1)*onepagelist;
	
		int bkpaging = 1; //기본으로는 총페이지는 1로 정의. 게시글이 많아지면 커진다.
		
		//받아온 사람의 번호로 그 사람의 데이터를 받아오자.
		try {
			Member_tbl fwinfo = mservice.selectbyno(fwNo);
			mv.addObject("fwinfo", fwinfo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("받아온 팔로워의 번호 : "+ fwNo);
		
		if(fwNo !=null) {
			try {
				//////////////////   도서    ///////////////////////////////////
				bklist = bservice.booklist(fwNo, onepagelist,bkoffset); //도서 내가 쓴 도서쪽 모든 글정보 가지고옴.
				int bklistsize = bservice.bookcnt(fwNo);
				
				bkpaging = (int)Math.ceil(bklistsize*1.0/onepagelist);	//도서 총 페이징 수 
				System.out.println("bkpaging : "+ bkpaging);
				
				mv.addObject("bkpagingcnt", bkpaging);  //도서 처음 팔로워게시글 가면 보이는 페이징수
				
				if(bklist !=null) {
					mv.addObject("booklist", bklist);
				}
				
				mv.addObject("fwNo", fwNo);
				
				mv.setViewName("follower/followerBookBoard");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@RequestMapping("/fwMovieBoard")
	public ModelAndView fwMovieBoard(Integer fwNo, @RequestParam(value = "mvnum", defaultValue = "1") int mvnum) { //받아온 사람의 번호 , 몇번째 페이지를 보여줄건지.
		
		ModelAndView mv = new ModelAndView();
		
		List<Board> mvlist =null; //영화 리스트

		int onepagelist = 3; //한페이지에 2개씩 불러오자.
		
		int mvoffset = (mvnum-1)*onepagelist;
		
		int mvpaging = 1; //기본으로는 총페이지는 1로 정의. 게시글이 많아지면 커진다.
		
		//받아온 사람의 번호로 그 사람의 데이터를 받아오자.
		try {
			Member_tbl fwinfo = mservice.selectbyno(fwNo);
			mv.addObject("fwinfo", fwinfo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("받아온 팔로워의 번호 : "+ fwNo);
		
		if(fwNo !=null) {
			try {
				/////////////////    영화    /////////////////////////////////////////
				
				mvlist = bservice.movielist(fwNo, onepagelist,mvoffset);
				int mvlistsize = bservice.moviecnt(fwNo);
				
				mvpaging = (int)Math.ceil(mvlistsize*1.0/onepagelist);	
				System.out.println("mvpaging : "+ mvpaging);
				
				mv.addObject("mvpagingcnt", mvpaging);  

				if(mvlist !=null) {
					mv.addObject("movielist", mvlist);
				}

				mv.addObject("fwNo", fwNo);
				
				mv.setViewName("follower/followerMovieBoard");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@RequestMapping("/fwTheaterBoard")
	public ModelAndView fwTheaterBoard(Integer fwNo, @RequestParam(value = "thnum", defaultValue = "1") int thnum) { //받아온 사람의 번호 , 몇번째 페이지를 보여줄건지.
		
		ModelAndView mv = new ModelAndView();

		List<Board> thlist =null; //연극 리스트

		int onepagelist = 3; //한페이지에 2개씩 불러오자.

		int thoffset = (thnum-1)*onepagelist;

		int thpaging = 1; //기본으로는 총페이지는 1로 정의. 게시글이 많아지면 커진다.
		
		//받아온 사람의 번호로 그 사람의 데이터를 받아오자.
		try {
			Member_tbl fwinfo = mservice.selectbyno(fwNo);
			mv.addObject("fwinfo", fwinfo);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("받아온 팔로워의 번호 : "+ fwNo);
		
		if(fwNo !=null) {
			try {		
				/////////////////    영화    /////////////////////////////////////////
				
				thlist = bservice.theaterlist(fwNo, onepagelist,thoffset);
				int thlistsize = bservice.theatercnt(fwNo);
				
				thpaging = (int)Math.ceil(thlistsize*1.0/onepagelist);	
				System.out.println("thpaging : "+ thpaging);
				
				mv.addObject("thpagingcnt", thpaging); 

				if(thlist !=null) {
					mv.addObject("theaterlist", thlist);
				}
				mv.addObject("fwNo", fwNo);
				
				mv.setViewName("follower/followerTheaterBoard");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}
	

	
}
