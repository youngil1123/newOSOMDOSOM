package com.osom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.Friendship;
import com.osom.frame.MyMapper;

@Mapper
@Repository
public interface FriendshipMapper extends MyMapper<Integer,Friendship>{

	Integer check(Friendship f);

	void fwdelete(Friendship f);
	
	public int followercnt(int mem_no); 

}
