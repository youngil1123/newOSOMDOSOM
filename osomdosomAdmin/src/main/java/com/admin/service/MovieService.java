package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.MovieInfo;
import com.admin.frame.MyService;
import com.admin.mapper.MovieMapper;
@Service
public class MovieService implements MyService<String, MovieInfo>{

	@Autowired
	MovieMapper moviemapper;
	@Override
	public void register(MovieInfo v) throws Exception {
	
		moviemapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(MovieInfo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MovieInfo get(String k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieInfo> get() throws Exception {
		//영화리스트 가져오기
		return moviemapper.selectall();
	}
	public List<String> getmoviecd() throws Exception{
		return moviemapper.getmoviecd();
	}
	public void updateconno(MovieInfo m) throws Exception{
		moviemapper.updateconno(m);
	}
	public List<MovieInfo> searchmovielist(String keyword) throws Exception{
		return moviemapper.searchmovielist(keyword);
	}
	public int countcon() throws Exception{
		return moviemapper.countcon();
	}


}
