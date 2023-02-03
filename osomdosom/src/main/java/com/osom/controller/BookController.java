package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.osom.dto.BookInfo;
import com.osom.service.BoardService;
import com.osom.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookservice;
	@Autowired
	BoardService boardservice;
	@RequestMapping("/review/bookreview")
	public String bookreview(int book_no,Model model) {
		//책 하나 리뷰 보는 페이지로 이동(책 정보 + 리뷰정보를 가지고)
		//
		BookInfo book= null;
		List<BookInfo> bookreview= new ArrayList<BookInfo>();
		try {
			book = bookservice.get(book_no);
			System.out.println(book);
			bookreview = bookservice.getonebookreview(book_no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("book", book);
		model.addAttribute("bookreview", bookreview);
		
		
		return "review/bookreview";
		
	}
}
