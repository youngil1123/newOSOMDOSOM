package com.osom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.BookInfo;
import com.osom.dto.Paging;
import com.osom.frame.MyMapper;
@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookInfo> {
	public List<Integer> getbookno();
	public void updatebookcd(BookInfo b);
	public List<BookInfo> searchbooklist(String keyword);
	public List<BookInfo> getbookreview();
	public List<BookInfo> getonebookreview(int book_no);//
	public int totalRecord(int book_no); //책 하나의 리뷰 수 구하기
	public List<BookInfo> boardPageSelect(Paging p); //리뷰페이지
}
