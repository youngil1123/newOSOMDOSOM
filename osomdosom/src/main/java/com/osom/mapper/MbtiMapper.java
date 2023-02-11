package com.osom.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.BookInfo;
import com.osom.dto.Mbti;
import com.osom.dto.MovieInfo;
import com.osom.dto.TheaterInfo;
import com.osom.frame.MyMapper;

@Mapper
@Repository
public interface MbtiMapper extends MyMapper<String,Mbti>{
	public int countmbtimemno(String mbti); //엠비티아이 별로 사용자 수
	public List<Mbti> getconnoAndcountmem(String mbti);//해당 mbti가 가장 많이 쓴 컨텐츠 번호 불러오기
	public String getcongenreByconno(int con_no); //컨텐츠 넘버로 장르 분별하기..
	public Mbti getconByconnoBook(int con_no); //컨텐츠 넘버로 책정보 가져오기
	public Mbti getconByconnoMovie(int con_no); //컨텐츠 넘버로 영화정보 가져오기
	public Mbti getconByconnoTheater(int con_no); //컨텐츠 넘버로 연극정보 가져오기

}	
	
	

