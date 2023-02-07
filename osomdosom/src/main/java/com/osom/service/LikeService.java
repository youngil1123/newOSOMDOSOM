package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.Like_list;
import com.osom.frame.MyService;
import com.osom.mapper.LikeMapper;
@Service
public class LikeService implements MyService<Integer, Like_list>{

	@Autowired
	LikeMapper likemapper;
	@Override
	public void register(Like_list v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Like_list v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Like_list get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Like_list> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	//찜 상태 체크
	public int likeStateCheck(Like_list l) throws Exception{
		return likemapper.likeStateCheck(l);
	}
	//찜 목록 삭제
	public void likeremove(Like_list l) throws Exception{
		likemapper.likeremove(l);
	}
	//찜 목록 추가
	public void likeadd(Like_list l) throws Exception{
		likemapper.likeadd(l);
	}

}