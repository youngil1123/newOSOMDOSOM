package com.admin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Member_tbl {
	
	private Integer mem_no;
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_tel;
	private String mem_email;
	private String mbti;
	private String nickname;
	private int mem_point;
	private String mem_img;
	private String heart;
	
	private String ban;


// 이메일 찾기

	
//회원가입
	public Member_tbl(String mem_name,String mem_id, String mem_pwd,String mem_email, String mbti, String nickname) {
		super();	
		this.mem_name=mem_name;
		this.mem_id=mem_id;
		this.mem_pwd=mem_pwd;
		this.mem_email=mem_email;
		this.mbti=mbti;
		this.nickname=nickname;
	}
	

// 아이디 찾기

	Member_tbl(String mem_name, String mem_email) {
		super();
		this.mem_name=mem_name;
		this.mem_email=mem_email;
	}
	/*
	 * // 비밀번호 찾기 Member_tbl(String mem_id,String mem_email) { super();
	 * this.mem_email=mem_email;
	 * 
	 * }
	 */
	Member_tbl(String ban, int mem_no){
		super();
		this.ban=ban;
		this.mem_no=mem_no;
	}
	

}
