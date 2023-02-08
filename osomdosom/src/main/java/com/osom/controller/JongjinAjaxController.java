package com.osom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Board;
import com.osom.dto.Friendship;
import com.osom.dto.Member_tbl;
import com.osom.service.BoardService;
import com.osom.service.FriendshipService;
import com.osom.service.Member_tblService;

@RestController
@RequestMapping("/follower")
public class JongjinAjaxController {

	@Autowired
	Member_tblService mservice;

	@Autowired
	FriendshipService fservice;
	
	@Autowired
	BoardService bservice;

	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = null;
		Member_tbl member = null;

		try {
			member = mservice.get(cid);
			if (member != null) {
				String imgname = member.getMem_img();
				result = imgname;
				if (result == null || result == "") {
					result = "follow.png";
				}
			} else {
				result = null;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/AddFwTbl")
	public Object addFollower(String fwid, HttpServletRequest request) throws Exception {

		Friendship friendship = new Friendship();

		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust");

		int myid_no = mservice.findmem_no(member.getMem_id());
		int fwid_no = mservice.findmem_no(fwid);

		friendship.setMem_no(myid_no);
		friendship.setMem_no2(fwid_no);

		Integer chk = fservice.get(friendship);
		if (chk == null) {
			if (myid_no == fwid_no) {
				return "myself";
			} else {
				fservice.register(friendship);

				return fwid;
			}
		} else {
			return "false";
		}

	}

	@RequestMapping("/DeleteFw")
	public ModelAndView DeleteFw(String dfwid, HttpServletRequest request) throws Exception {

		ModelAndView mv = new ModelAndView();

		Friendship friendship = new Friendship();

		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust"); // 로그인한 아이디의 정보

		int myid_no = mservice.findmem_no(member.getMem_id());
		int dfwid_no = mservice.findmem_no(dfwid);

		friendship.setMem_no(myid_no);
		friendship.setMem_no2(dfwid_no);

		Integer chk = fservice.get(friendship);

		if (chk != null) {
			fservice.remove(friendship);

			mv.setViewName("/follower/deleteFollower");
			mv.addObject("dfwid", dfwid);
		}
		return mv;
	}

	@RequestMapping("/FollowerPage")
	public ModelAndView FollowerPage(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust");

		String myid = "";

		if (member != null) { // 로그인이 되어있는 경우
			myid = member.getMem_id();

			mv.setViewName("/follower/deleteFollower");
		} else {
			mv.setViewName("/login");
		}

		return mv;
	}
	

}

