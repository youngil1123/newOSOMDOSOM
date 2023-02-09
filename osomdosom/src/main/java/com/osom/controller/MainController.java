package com.osom.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osom.dto.Board;
import com.osom.dto.Member_tbl;
import com.osom.frame.CryptoUtil;
import com.osom.service.BoardService;
import com.osom.service.Member_tblService;

@Controller
public class MainController {
	
	@Autowired
	Member_tblService mservice;
	
	@Autowired
	BoardService bservice;
	
	@RequestMapping("/")
    public String main() {
        return "index";
    }
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("top", "login");
		return "login";
	}
	@RequestMapping("/recentreview")
	@ResponseBody
	public List<Board> getrecentreview(){
		// 최신 글 5개 가져오기..
		List<Board> reviews = new ArrayList<Board>();
		try {
			reviews = bservice.recentreview();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reviews;
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String mem_id, String mem_pwd, Model model) {
		Member_tbl member = null;
	    Date date = new Date();
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        String today = format.format(date);
	        System.out.println("today"+today);
	      
		try {
			member = mservice.get(mem_id);
			  String mtoday= member.getToday();
			  	if(mtoday==null) { 
				  		System.out.println("member.getToday()"+mtoday);
					if (member != null) {
						String key = "osomdosompasswd0077";
						String decryptpwd = CryptoUtil.decryptAES256(member.getMem_pwd(), key);
						
					if(decryptpwd.equals(mem_pwd)) {
							// 성공시에만 이걸로 바뀜. 디폴트는 로그인 fail.
							session.setAttribute("logincust", member);
							if(!today.equals(mtoday)) {
								mservice.updatePoint(member.getMem_no());
								mservice.logindate(member.getMem_no(),today);
								return "loginOk";
							}
							return "index";
						}
					}
			  	}else {
			  		 System.out.println("member.getToday()"+mtoday);
						if (member != null) {
							String key = "osomdosompasswd0077";
							String decryptpwd = CryptoUtil.decryptAES256(member.getMem_pwd(), key);
							
						if(decryptpwd.equals(mem_pwd)) {
								// 성공시에만 이걸로 바뀜. 디폴트는 로그인 fail.

								
								session.setAttribute("logincust", member);
								if(!mtoday.equals(today)) {
									mservice.updatePoint(member.getMem_no());
									mservice.logindate(member.getMem_no(),mtoday);
									return "loginOk";
								}
								return "index";
							}
						}
			  	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "loginfail";
	};
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("session", session);
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("top", "register");
		return "register";
	}
	
	@RequestMapping("/about")
    public String about() {
        return "about";
    }
	
	
	@RequestMapping("/lostinfo")
	 public String lostinfo(){
		 return "lostinfo";
	 }

}
