package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.TheaterInfo;
import com.admin.frame.MyMapper;
@Repository
@Mapper
public interface TheaterMapper extends MyMapper<String, TheaterInfo> {
	public List<String> getcd(String genrenm);
	public void updateconno(TheaterInfo t);
	public List<TheaterInfo> searchtheaterlist(String keyword);
	public List<TheaterInfo> gettheaterreviews();
	public List<TheaterInfo> getcontents(String genrenm);
	public int countcon(String genrenm);
}
