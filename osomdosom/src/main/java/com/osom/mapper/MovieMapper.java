package com.osom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.BookInfo;
import com.osom.dto.MovieInfo;
import com.osom.frame.MyMapper;
@Repository
@Mapper
public interface MovieMapper extends MyMapper<String, MovieInfo> {
	public List<String> getmoviecd();
	public void updateconno(MovieInfo m);
	public List<MovieInfo> searchmovielist(String keyword);
	public List<MovieInfo> getmoviereview();
	public List<MovieInfo> getonemoviereview(String movieCd);
}
