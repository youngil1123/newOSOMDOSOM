package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.MovieInfo;
import com.osom.dto.Paging;
import com.osom.dto.TheaterInfo;
import com.osom.frame.MyService;
import com.osom.mapper.TheaterMapper;
@Service
public class TheaterService implements MyService<String, TheaterInfo>{

	@Autowired
	TheaterMapper theatermapper;
	
	@Override
	public void register(TheaterInfo v) throws Exception {
		theatermapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(TheaterInfo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TheaterInfo get(String k) throws Exception {
		// TODO Auto-generated method stub
		return theatermapper.select(k);
	}
	
	@Override
	public List<TheaterInfo> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getcd(String genrenm) throws Exception{
		return theatermapper.getcd(genrenm);
	}
	public void updateconno(TheaterInfo t) throws Exception{
		theatermapper.updateconno(t);
	}
	public List<TheaterInfo> searchtheaterlist(String keyword){
		return theatermapper.searchtheaterlist(keyword);
	}
	public List<TheaterInfo> gettheaterreview(String genrenm) throws Exception{
		return theatermapper.gettheaterreview(genrenm);
	}
	public List<TheaterInfo> getonetheaterreview(String mt20id) throws Exception{
		//
		return theatermapper.getonetheaterreview(mt20id);
	}
	public int totalRecord(Paging p) throws Exception{
		// 공연의 리뷰개수 구하기
		return theatermapper.totalRecord(p);
	}
	public List<TheaterInfo> boardPageSelect(Paging p) throws Exception{
		//리뷰페이지
		return theatermapper.boardPageSelect(p);
	}


	


}
