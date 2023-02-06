package com.osom.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.Board;
import com.osom.frame.MyMapper;
import com.osom.service.BoardService;

@Mapper
@Repository
public interface BoardMapper extends MyMapper<Integer,Board>{
	public List<Board> searchmylist(Integer mem_no); 
	public List<Board> searchmylist(String mem_id);
	public Board get(int mem_no);
	public void deletepost(int board_no);
	public Board findById(int board_no);
	public void updatepost(Board board);
	
	
	
}
	
	

