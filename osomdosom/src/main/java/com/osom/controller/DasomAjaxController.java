package com.osom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Member_tbl;
import com.osom.service.Member_tblService;

@RestController
/*@RequestMapping("/go")*/
public class DasomAjaxController {
	@Autowired
	Member_tblService mservice;
	
	
	
	//아이디찾기
	@RequestMapping("/findid")
	public Object findid(String mem_name, String mem_email) {
		
        String mem_id = null;
        try {
            mem_id = mservice.findid(mem_name, mem_email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mem_id;
    }
	
	
	//비밀버호찾기
    @RequestMapping("/findpwd")
    public Object findpwd(String mem_id, String mem_email) {
        String mem_pwd = null;
        try {
            mem_pwd = mservice.findpwd(mem_id, mem_email);
            System.out.println(mem_pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mem_pwd;
    }
    
  //아이디 중복체크
    @RequestMapping("/idCheck")
  		public int idCheck(String mem_id) {
			int cnt = mservice.idCheck(mem_id);
			System.out.println(cnt);
  			return cnt;
  			
  		}

    
    
	// 로그인이 되어있어야 팔로워 페이지로 이동, 아닐경우 로그인 페이지로 이동
	@RequestMapping("/pointshop")
	public ModelAndView pointshop(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust");

		String myid = "";

		if (member != null) { // 로그인이 되어있는 경우
			myid = member.getMem_id();
//			System.out.println(myid);

			mv.setViewName("/pointshop");
		} else {
			mv.setViewName("/login");
		}

		return mv;
	}
	

}
