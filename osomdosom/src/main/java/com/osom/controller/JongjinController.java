package com.osom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Friendship;
import com.osom.dto.Member_tbl;
import com.osom.service.FriendshipService;
import com.osom.service.Member_tblService;


@Controller
@RequestMapping("/follower")
public class JongjinController {
	
	@Autowired
	Member_tblService mservice;
	
	@Autowired
	FriendshipService fservice;
	
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
	

	

	
}
