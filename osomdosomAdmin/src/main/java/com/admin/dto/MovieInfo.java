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
public class MovieInfo {
	private String movieCd; // 영화코드
	private String movieNm; // 영화명(한글)
	private String movieNmEn; // 영화명(영문)
	private String genreAlt; // 장르
	private String openDt; // 개봉일
	private String peopleNm; // 감독명
	private String showTm; // 상영시간
	private int con_no;
	

	

	
}
