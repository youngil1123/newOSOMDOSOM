package com.osom.dto;

import java.util.Date;

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
public class MovieInfo {
	private String movieCd; // 영화코드
	private String movieNm; // 영화명(한글)
	private String movieNmEn; // 영화명(영문)
	private String genreAlt; // 장르
	private String openDt; // 개봉일
	private String peopleNm; // 감독명
	private String movieposter; // 영화포스터
	private String showTm; // 상영시간
	private int con_no;
	
	
	
	
	//board
    private int board_no;
	private int mem_no;
	private Date writedate;
	private String title;
	private String review;
	private String partner;
	private String secret_memo;
	private int star_rate;
	
	//member_tbl
	private String nickname;
	

	
}
