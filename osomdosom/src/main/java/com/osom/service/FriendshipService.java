package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.BookInfo;
import com.osom.dto.Friendship;
import com.osom.frame.MyService;
import com.osom.mapper.FriendshipMapper;

@Service
public class FriendshipService implements MyService<Integer, Friendship>{
	
	@Autowired
	FriendshipMapper mapper;

	@Override
	public void register(Friendship v) throws Exception {
		mapper.insert(v);
		
	}

	public void remove(Friendship k) throws Exception {
		mapper.fwdelete(k);
		
	}

	@Override
	public void modify(Friendship v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Friendship get(Integer k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Friendship> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<Friendship> addfollower(String mem_id, String mem_id2) throws Exception {
		
		return mapper.selectall();
	}



	public Integer get(Friendship f) {
		return mapper.check(f);

	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub

	}



	
}	