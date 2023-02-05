package com.osom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Paging {
	// 페이징
	private int nowPage = 1; // 현재페이지
	private int onePageRecord = 5; // 한페이지에 표시할 레코드수
	private int totalRecord; // 총레코드수
	private int totalPage; // 총페이지수
	
	//리뷰 선택을 위한 ======책번호,영화코드,공연코드
	private int book_no;
	private String movieCd;
	private String mt20id;
	private String genrenm;

	//
	private int startRecord=0; //페이지 시작할때 조회할 첫번째 레코드.
	// 페이지 번호
	private int onePageCount = 5; // 한번에 표시할 페이지 수
	private int startPage = 1;// 시작페이지
	private int selectRecord = onePageRecord;// 파미막 페이지 선택할 레코드수

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
		// 시작페이지 계산하기
		startPage = (((nowPage - 1) / onePageCount) * onePageCount) + 1;
	}

	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 총페이지수 구하기 올림 실수/정수 =실수
		totalPage = (int) Math.ceil((double) totalRecord / onePageRecord);
		// 마지막 페이지에 남아있는 레코드 수
		// 한페이지에 5개의 레코드를 선택시 남아있는 레코드 수는 1,2,3,4,5
		// 총레코드수 % 한페이지당 표시할 레코드수=0,1,2,3,4 -> 0은 5(한페이지당 레코드수)로 바꿔주기
		selectRecord = totalRecord % onePageRecord;
		if (selectRecord == 0)
			selectRecord = onePageRecord;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setSelectRecord(int selectRecord) {
		this.selectRecord = selectRecord;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public void setStartRecord(int startRecord) {
		this.startRecord = startRecord;
		startRecord=(nowPage-1)*onePageRecord;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public void setMt20id(String mt20id) {
		this.mt20id = mt20id;
	}

	public void setGenrenm(String genrenm) {
		this.genrenm = genrenm;
	}
	
	
//
}
