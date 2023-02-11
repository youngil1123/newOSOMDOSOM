package com.osom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Mbti {
	private String mbti;//엠비티아이
	private int con_no;//컨텐츠 넘버
	private double avgstar_rate;//평균평점
	private int mbtimemno; //MBTI별 이용자수 총 합
	private int oneconmem_no; //한 컨텐츠에 리뷰를 쓴 해당 mbti 이용자 수
	private String congenre;
	//책정보
	private int book_no;
	private String bookImageURL;
	//영화정보
	private String movieCd;
	private String movieposter;
	//연극정보
	private String mt20id;
	private String poster;
}
