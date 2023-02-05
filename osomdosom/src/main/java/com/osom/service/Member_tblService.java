package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.osom.dto.Mail;
import com.osom.dto.Member_tbl;
import com.osom.frame.MyService;
import com.osom.mapper.BoardMapper;
import com.osom.mapper.Member_tblMapper;

@Service
public class Member_tblService implements MyService<String, Member_tbl> {

	@Autowired
	Member_tblMapper mapper;
	
	@Autowired
	BoardMapper bmapper;
	
    @Autowired
	 private JavaMailSender mailSender;
	
	//회원가입
	@Override
	public void register(Member_tbl v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Member_tbl v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Member_tbl get(String k) throws Exception {
		return mapper.select(k);
		
	}

	@Override
	public List<Member_tbl> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<Member_tbl> getfollower(Integer myNo) throws Exception {
		return mapper.selectallfollower(myNo);
	}
	
	public int idCheck(String mem_id) {
		int cnt = mapper.idCheck(mem_id);
		System.out.println("cnt: " + cnt);
		return cnt;
	}	

	public String findid(String mem_name, String mem_email) {
		return mapper.findid(mem_name, mem_email);
	}

	public String findpwd(String mem_id, String mem_email) {
		return mapper.findpwd(mem_id, mem_email);
	}

	public Integer findmem_no(String mem_id) {
		
		return mapper.findmem_no(mem_id);
	}

	public void updateMyInfo(int mem_no, String mem_pwd, String nickname, String mbti, String mem_img, String myword) {
		mapper.updateMyInfo(mem_no, mem_pwd, nickname, mbti, mem_img, myword);
	}

	public void updatePoint(int mem_no) throws Exception {
		 mapper.updatePoint(mem_no);
	    }

	public Member_tbl selectMember(String email) throws Exception{
		return mapper.selectMember(email);
	
	}

	public void pwUpdate_M(Member_tbl vo) throws Exception {
		mapper.pwUpdate_M();
	}


	}



	
		




	

