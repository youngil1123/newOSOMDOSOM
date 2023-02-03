package com.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.admin.dto.BookInfo;
import com.admin.frame.MyMapper;
@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookInfo> {
	public List<Integer> getbookno();
	public void updatebookcd(BookInfo b);
	public List<BookInfo> searchbooklist(String keyword);
	public List<BookInfo> getbookreview();
	public List<BookInfo> getonebookreview(int book_no);//
	public int countcon();
}
	