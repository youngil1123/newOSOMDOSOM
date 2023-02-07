package com.osom.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.Like_list;
import com.osom.frame.MyMapper;

@Mapper
@Repository
public interface LikeMapper extends MyMapper<Integer,Like_list>{
	//아이디가 이 컨텐츠를 찜해놨는지 확인.
	public int likeStateCheck(Like_list l);
	//찜목록 삭제
	public void likeremove(Like_list l);
	//찜목록 추가
	public void likeadd(Like_list l);
}
	
	

