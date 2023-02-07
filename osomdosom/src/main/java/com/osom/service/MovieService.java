package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.BookInfo;
import com.osom.dto.MovieInfo;
import com.osom.dto.Paging;
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

	public int totalRecord(String movieCd) {
		//영화하나의 리뷰개수 구하기}
		return moviemapper.totalRecord(movieCd);
	}
	public List<MovieInfo> boardPageSelect(Paging p){ 
		//리뷰페이지
		return moviemapper.boardPageSelect(p);
	}
	public List<MovieInfo> getLikeContentsName(int mem_no) throws Exception{
		return moviemapper.getLikeContentsName(mem_no);
	}
	
}
