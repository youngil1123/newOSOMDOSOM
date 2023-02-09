package com.osom.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class Board {
	private int board_no;
	private int con_no;
	private int mem_no;
	private Date writedate;
	private String title;
	private String review;
	private String partner;
	private String secret_memo;
	private int star_rate;

	//member_tbl
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

	private MultipartFile img;
	private String myword;
}
