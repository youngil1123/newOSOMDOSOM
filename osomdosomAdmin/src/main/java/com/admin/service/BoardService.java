package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Board;
import com.admin.frame.MyService;
import com.admin.mapper.BoardMapper;

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

	
	public List<Board> list() throws Exception {
		return mapper.list();
	}
	
	public int countreview() throws Exception{
		return mapper.countreview();
	}

	}

