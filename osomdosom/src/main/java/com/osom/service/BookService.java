package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osom.dto.Board;
import com.osom.dto.BookInfo;
import com.osom.dto.MovieInfo;
import com.osom.frame.MyService;
import com.osom.mapper.BookMapper;
@Service
public class BookService implements MyService<Integer, BookInfo>{

	@Autowired
	BookMapper bookmapper;

	@Override
	public void register(BookInfo v) throws Exception {
		// TODO Auto-generated method stub
		bookmapper.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(BookInfo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookInfo get(Integer k) throws Exception {
		//책정보가져오기
		return bookmapper.select(k);
	}

	@Override
	public List<BookInfo> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Integer> getbookno() throws Exception{
		//책 순번들 가져오기
		return bookmapper.getbookno();
	}
	public void updatebookcd(BookInfo b) throws Exception{
		bookmapper.updatebookcd(b);
	}

	public List<BookInfo> searchbooklist(String keyword) throws Exception{
		//키워드로 책 리스트 검색하기
		return bookmapper.searchbooklist(keyword);
	}

	public List<BookInfo> getbookreview() throws Exception{
		return bookmapper.getbookreview();
	}
	public List<BookInfo> getonebookreview(int book_no) throws Exception{
		//
		return bookmapper.getonebookreview(book_no);
	}


}