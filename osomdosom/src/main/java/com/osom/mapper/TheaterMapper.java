package com.osom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.TheaterInfo;
import com.osom.frame.MyMapper;
@Repository
@Mapper
public interface TheaterMapper extends MyMapper<String, TheaterInfo> {
	public List<String> getcd(String genrenm);
	public void updateconno(TheaterInfo t);
	public List<TheaterInfo> searchtheaterlist(String keyword);
	public List<TheaterInfo> gettheaterreview(String genrenm);
	public List<TheaterInfo> getonetheaterreview(String mt20id);
}
