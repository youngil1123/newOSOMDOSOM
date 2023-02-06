package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.Board;
import com.osom.frame.MyService;
import com.osom.mapper.BoardMapper;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class BoardService implements MyService<Integer, Board>{
	
	
	
	@Autowired
	BoardMapper mapper;

	@Override
	public void register(Board board) throws Exception {
		mapper.insert(board);
	}

	@Override
	public void remove(Integer k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Board v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Board get(Integer k) throws Exception {
		return mapper.select(k);
	}

	public List<Board> searchmylist(Integer mem_no) throws Exception {
		return mapper.searchmylist(mem_no);
	}

	@Override
	public List<Board> get() throws Exception {
		return mapper.selectall();
	}

	
	public Object boardview(int mem_no) throws Exception {
		return mapper.get(mem_no);
	}


	public void deletePost(int board_no)throws Exception {
		// TODO Auto-generated method stub
		 mapper.deletepost(board_no);
	}

	public Board findPostById(int board_no) {
		// TODO Auto-generated method stub
		return mapper.findById(board_no);
	}

	public void updatePost(Board board) throws Exception {
		// TODO Auto-generated method stub
		 mapper.updatepost(board);
	}

	

	


	}

