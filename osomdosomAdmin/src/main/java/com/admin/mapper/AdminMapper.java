package com.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Admin;
import com.admin.frame.MyMapper;
@Repository
@Mapper
public interface AdminMapper extends MyMapper<Integer, Admin>{
	public int adminlogin(Admin adm);
}
