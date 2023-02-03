package com.admin.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.Member_tbl;
import com.admin.frame.MyMapper;

@Mapper
@Repository
public interface Member_tblMapper extends MyMapper<String,Member_tbl>{

}
