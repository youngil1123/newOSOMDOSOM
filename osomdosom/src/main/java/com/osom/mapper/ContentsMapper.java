package com.osom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.Contents;
import com.osom.frame.MyMapper;
@Repository
@Mapper
public interface ContentsMapper extends MyMapper<Integer, Contents> {
	public int getconno(String con_cd);
}
