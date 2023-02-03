package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.MovieInfo;
import com.admin.frame.MyMapper;
@Repository
@Mapper
public interface MovieMapper extends MyMapper<String, MovieInfo> {
	public List<String> getmoviecd();
	public void updateconno(MovieInfo m);
	public List<MovieInfo> searchmovielist(String keyword);
	public int countcon();
}
