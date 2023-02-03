package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.BookInfo;
import com.osom.dto.Paging;
import com.osom.service.BoardService;
import com.osom.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookservice;
	@Autowired
	BoardService boardservice;
	@RequestMapping("/review/bookreview")
	public String bookreview(int book_no,Model model,Paging p) {
		//책 하나 리뷰 보는 페이지로 이동(책 정보 + 리뷰정보를 가지고)
		//
		BookInfo book= null;
		List<BookInfo> bookreview= new ArrayList<BookInfo>();
		try {
			book = bookservice.get(book_no);
			p.setTotalRecord(bookservice.totalrecord(book_no));
			p.setBook_no(book_no);
			p.setStartRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(book);
			System.out.println(p);
			bookreview = bookservice.boardPageSelect(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p);
		model.addAttribute("book", book);
		model.addAttribute("bookreview", bookreview);
		model.addAttribute("p", p);
		
		
		return "review/bookreview";
		
	}
}
