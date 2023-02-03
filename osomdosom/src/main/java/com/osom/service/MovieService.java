package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.BookInfo;
import com.osom.dto.MovieInfo;
import com.osom.frame.MyService;
import com.osom.mapper.MovieMapper;
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
		return moviemapper.select(k);
	}

	@Override
	public List<MovieInfo> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	
	public List<MovieInfo> getmoviereview() throws Exception{
		return moviemapper.getmoviereview();
	}
	
	public List<MovieInfo> getonemoviereview(String movieCd) throws Exception{
		//
		return moviemapper.getonemoviereview(movieCd);
	}


}
