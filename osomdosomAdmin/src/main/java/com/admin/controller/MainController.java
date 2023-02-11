package com.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.dto.Admin;
import com.admin.dto.Board;
import com.admin.dto.BookInfo;
import com.admin.dto.Member_tbl;
import com.admin.dto.MovieInfo;
import com.admin.dto.TheaterInfo;
import com.admin.service.AdminService;
import com.admin.service.BoardService;
import com.admin.service.BookService;
import com.admin.service.Member_tblService;
import com.admin.service.MovieService;
import com.admin.service.TheaterService;

@Controller
public class MainController {

	@Autowired
	AdminService aservice;

	@Autowired
	Member_tblService mservice;
	
	@Autowired
	BoardService bservice;
	
	@Autowired
	MovieService movieservice;
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	TheaterService theaterservice;
	@RequestMapping("/")
	public String main() {
		return "adminIndex";
	}
	@RequestMapping("/membercontrol")
	public String membercontrol(Model model) {
		List<Member_tbl> members = new ArrayList<Member_tbl>();
		try {
			members = mservice.get();
			model.addAttribute("members", members);
			int membernumber = mservice.countmember();
			model.addAttribute("membernumber", membernumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "memberlist";
	}

	@RequestMapping("/main")
	public String mainpage(HttpSession session,Model model) {
		
		if(session.getAttribute("admin")!=null) {
			
		}
		else {
			model.addAttribute("login_need_msg", "로그인이 필요한 서비스입니다.");
			return "adminIndex";
		}
		//세션에 로그인 되어있으면 메인으로 이동
		return "adminDashBoard";
	}
	@RequestMapping("/loginimpl")
	public String login(Model model,HttpSession session,String admin_id,String admin_pwd) {
		Admin adm = new Admin();
		adm.setAdmin_id(admin_id);
		adm.setAdmin_pwd(admin_pwd);
		try {
			System.out.println(adm);
			//1.DB에 있는 어드민과 로그인정보가 같은지 확인
			int result = aservice.adminlogin(adm);
			System.out.println(result);
			if(result==1){//로그인성공
				//2.로그인 성공시 세션에 로그인 정보 저장 -> 관리 페이지로 이동
				session.setAttribute("admin", adm);
				return "adminDashBoard";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//로그인 실패시
		model.addAttribute("login_fail_msg", "로그인 실패! 다시시도해주세요");
		return "adminIndex";
	}
	@RequestMapping("/reviewlist")
	public String reviewlist(Model model) {
		//모든 게시글 불러오기.
		List<Board> boards = new ArrayList<Board>();
		try {
			boards = bservice.list();
			model.addAttribute("boards", boards);
			model.addAttribute("reviewnumber", bservice.countreview());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "reviewlist";
	}
	@RequestMapping("/contentslist")
	public String contentslist(Model model) throws Exception{
		//콘텐츠리스트 넘겨주기 
		//1.영화리스트
		List<MovieInfo> movies = new ArrayList<MovieInfo>();
		movies = movieservice.get();
		model.addAttribute("moviecon_num", movieservice.countcon());
		model.addAttribute("movies", movies);
		//2.책리스트
		List<BookInfo> books = new ArrayList<BookInfo>();
		books = bookservice.get();
		model.addAttribute("bookcon_num", bookservice.countcon());
		model.addAttribute("books", books);
		//3.연극리스트
		List<TheaterInfo> theaters = new ArrayList<TheaterInfo>();
		theaters= theaterservice.getcontents("연극");
		model.addAttribute("theaters", theaters);
		model.addAttribute("theatercon_num", theaterservice.countcon("연극"));
		//4.뮤지컬리스트
		List<TheaterInfo> musicals = new ArrayList<TheaterInfo>();
		musicals= theaterservice.getcontents("뮤지컬");
		model.addAttribute("musicals", musicals);
		model.addAttribute("musicalcon_num", theaterservice.countcon("뮤지컬"));
		return "contentslist";
	}
	
	
	@RequestMapping("/bann")
	public ModelAndView bann (String mem_id) {
		
		System.out.println("controller 들어왓는지 : "+mem_id);
		
		Member_tbl mem;
		String ban = null;
		int mem_no=0;
		ModelAndView mv = new ModelAndView();
		String memberid = mem_id;
		try {
			mem = mservice.selectbyid(memberid);
			System.out.println("try 들어왓는지 : "+mem);
			
			if(mem != null) {
				mem_no=mem.getMem_no();
				ban = mem.getBan();
				System.out.println("mem != 들어왓는지 mem_no : "+mem_no+"  ban : "+ban);
				
				if(ban == null || ban=="") {
					ban = "no";
					System.out.println("ban=='' 들어왓는지 : "+mem_id);
					
				}
				System.out.println("여기까지 왓는가?");
				if(ban.equals("yes")) {
					ban = "no";
					mservice.banned(ban, mem_no);
					System.out.println("ban : "+ban);
					mv.setViewName("gotomemberlist");
					
					return mv;
				}else if(ban.equals("no")) {
					ban = "yes";
					mservice.banned(ban, mem_no);
					System.out.println("ban : "+ban);
					mv.setViewName("gotomemberlist");
					return mv;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ban="";
			
			
		}
		return mv;
		
	}
}
