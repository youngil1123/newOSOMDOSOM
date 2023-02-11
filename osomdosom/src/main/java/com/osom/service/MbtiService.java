package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.BookInfo;
import com.osom.dto.Mbti;
import com.osom.dto.MovieInfo;
import com.osom.dto.TheaterInfo;
import com.osom.frame.MyService;
import com.osom.mapper.MbtiMapper;

@Service
public class MbtiService implements MyService<String, Mbti> {

	@Autowired
	MbtiMapper mapper;

	@Override
	public void register(Mbti v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(Mbti v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Mbti get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mbti> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// MBTI별 이용자수 총 합
	public int countmbtimemno(String mbti) {
		return mapper.countmbtimemno(mbti);
	}

	public List<Mbti> getconnoAndcountmem(String mbti) {
		return mapper.getconnoAndcountmem(mbti);
	}

	public String getcongenreByconno(int con_no) {
		// 컨텐츠 넘버로 장르 분별하기..
		return mapper.getcongenreByconno(con_no);
	}

	public Mbti getconByconnoBook(int con_no) {
		// 컨텐츠 넘버로 책정보 가져오기
		return mapper.getconByconnoBook(con_no);
	}

	public Mbti getconByconnoMovie(int con_no) {
		// 컨텐츠 넘버로 영화정보 가져오기
		return mapper.getconByconnoMovie(con_no);
	}

	public Mbti getconByconnoTheater(int con_no) {
		// 컨텐츠 넘버로 연극,뮤지컬 정보 가져오기
		return mapper.getconByconnoTheater(con_no);
	}

}
