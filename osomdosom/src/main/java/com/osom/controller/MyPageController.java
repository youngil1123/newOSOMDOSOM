package com.osom.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.BookInfo;
import com.osom.dto.Member_tbl;
import com.osom.dto.MovieInfo;
import com.osom.dto.TheaterInfo;
import com.osom.frame.CryptoUtil;
import com.osom.frame.ImgUtil;
import com.osom.service.BoardService;
import com.osom.service.BookService;
import com.osom.service.FriendshipService;
import com.osom.service.LikeService;
import com.osom.service.Member_tblService;
import com.osom.service.MovieService;
import com.osom.service.TheaterService;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	Member_tblService mservice;

	@Autowired
	FriendshipService fservice;
	
	@Autowired
	BoardService bservice;

	@Value("${memimgdir}")
	String memimgdir;
	
	@Autowired
	BookService bookservice;

	@Autowired
	LikeService likeservice;
	
	@Autowired
	MovieService movieservice;
	
	@Autowired
	TheaterService theaterservice;
	
	@RequestMapping("")
	public ModelAndView mypage(HttpServletRequest request) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		Member_tbl myinfo = (Member_tbl) session.getAttribute("logincust"); // 로그인한 내 정보들
		int mem_no = myinfo.getMem_no();
		//찜한 책정보 가져가기
		List<BookInfo> books = new ArrayList<BookInfo>();
		//찜한 영화정보 가져가기
		List<MovieInfo> movies = new ArrayList<MovieInfo>();
		//찜한 연극정보 가져가기
		List<TheaterInfo> theaters = new ArrayList<TheaterInfo>();
		//찜한 뮤지컬정보 가져가기
		List<TheaterInfo> musicals = new ArrayList<TheaterInfo>();
		try {
			books = bookservice.getLikeContentsName(mem_no);
			mv.addObject("books", books);
			movies = movieservice.getLikeContentsName(mem_no);
			mv.addObject("movies", movies);
			theaters=theaterservice.getLikeContentsNameT(mem_no);
			mv.addObject("theaters", theaters);
			musicals=theaterservice.getLikeContentsNameM(mem_no);
			mv.addObject("musicals", musicals);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("mypage/mypage");
		mv.addObject("myinfo", myinfo);
		return mv;
	}

	@RequestMapping("/updateMyInfo")
	public Object updateMyInfo(HttpServletRequest request, Member_tbl member)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		HttpSession session = request.getSession();

		Member_tbl myinfo = (Member_tbl) session.getAttribute("logincust"); // 로그인한 내 정보들 <-여기서 수정해야함.
		int myno = myinfo.getMem_no();
		String myid = myinfo.getMem_id();

		String chpwd = member.getMem_pwd(); // 받아온 정보들
		System.out.println("내가입력한 비번: " + chpwd);
		String chnickname = member.getNickname();
		System.out.println("내가입력한 닉네임: " + chnickname);
		String chmbti = member.getMbti().toUpperCase();
		System.out.println("내가입력한 mbti: " + chmbti);
		String chimg = null;
		String chmyword = member.getMyword();
		
		chimg = member.getImg().getOriginalFilename(); // DTO의 MultipartFile 를사용함(화면에서 이미지파일올릴때 이미지파일이름을 가져옴)
		System.out.println("내가입력한 이미지: " + chimg);
		
		if (chimg == null || chimg.equals("")) {
			System.out.println("이미지추가를 안한걸로 나와요");
			try {
				chimg = myinfo.getMem_img(); // 이미지를 업뎃안할때는 기존의 이미지를 가지고 와야지
				System.out.println("입력안할때 : " + chimg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				chimg = member.getImg().getOriginalFilename(); // DTO의 MultipartFile 를사용함(화면에서 이미지파일올릴때 이미지파일이름을 가져옴)
				System.out.println("내가입력한 이미지2: " + chimg); 
				ImgUtil.saveFile(member.getImg(), memimgdir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (chpwd.length() == 0) { // 받아온 정보들의 길이가 0이면 기존의 정보를 넣어주자.
			chpwd = myinfo.getMem_pwd();
		} else if (chpwd.length() != 0) {
			String key = "osomdosompasswd0077";
			String enStr = CryptoUtil.encryptAES256(chpwd, key);
			chpwd = enStr;
		}
		if (chnickname.length() == 0) {
			chnickname = myinfo.getNickname();
		}
		if (chmbti.length() == 0) {
			chmbti = myinfo.getMbti();
		}
		if (chmyword.length() == 0) {
			chmyword = myinfo.getMyword();
		}


		mservice.updateMyInfo(myno, chpwd, chnickname, chmbti, chimg , chmyword); // <- dto에 회원번호, 비번,

		Member_tbl newMyInfo = new Member_tbl();
		try {
			newMyInfo = mservice.get(myid);
			System.out.println("newMyInfo2:" + newMyInfo);
			session.setAttribute("logincust", newMyInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/";
	}
	

	
	@RequestMapping("/deleteChk")
	public Object deleteChk(Model model, Member_tbl inputinfo, HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		//return 값.
		String result ="";
		
		//세션의 정보들 
		HttpSession session = request.getSession();
		Member_tbl myinfo = (Member_tbl)session.getAttribute("logincust");
		String myid = myinfo.getMem_id();
		System.out.println("기존 아이디 : "+ myid);
		String mypwd = myinfo.getMem_pwd(); //이건 암호화되어있다.
		System.out.println("기존 패스워드 : "+ mypwd);
		String myemail = myinfo.getMem_email();
		System.out.println("기존 이메일 : "+ myemail);
		Integer myno =myinfo.getMem_no();
				
		//내가 입력한 정보들
		String inputid = inputinfo.getMem_id();
		System.out.println("내가적은 아이디 : "+ inputid);
		String inputpwd = inputinfo.getMem_pwd(); //이건 암호화안되있음
		System.out.println("내가적은 패스워드 : "+ inputpwd);
		String inputemail = inputinfo.getMem_email();
		System.out.println("내가적은 이메일 : "+ inputemail);
		
		if(!myid.equals(inputid)) {
			result="입력하신 아이디 정보가 틀렸습니다. 확인 바랍니다.";
			model.addAttribute("result", result);
			return "/mypage/deleteAfter";
		}
		if(!myemail.equals(inputemail)) {
			result="입력하신 이메일 정보가 틀렸습니다. 확인 바랍니다.";
			model.addAttribute("result", result);
			return "/mypage/deleteAfter";
		}
		
		String key = "osomdosompasswd0077";
		String enStr = CryptoUtil.encryptAES256(inputpwd, key);
		inputpwd = enStr;
		System.out.println("내가적은 패스워드 (암호화) : "+ inputpwd);
		
		if(!mypwd.equals(inputpwd)) {
			result="입력하신 비밀번호 정보가 틀렸습니다. 확인 바랍니다.";
			model.addAttribute("result", result);
			return "/mypage/deleteAfter";
		}
		
		try {
			session.invalidate();
			mservice.remove(inputid);
			fservice.remove(myno);
			bservice.remove(myno);
			result="회원탈퇴가 완료 되었습니다.";
			model.addAttribute("result", result);
			return "/mypage/deleteAfter";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result ;
	}


}
