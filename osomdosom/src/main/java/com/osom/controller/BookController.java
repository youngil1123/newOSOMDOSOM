package com.osom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.osom.dto.BookInfo;
import com.osom.dto.Like_list;
import com.osom.dto.Member_tbl;
import com.osom.dto.Paging;
import com.osom.service.BoardService;
import com.osom.service.BookService;
import com.osom.service.LikeService;

@Controller
public class BookController {

	@Autowired
	BookService bookservice;
	@Autowired
	BoardService boardservice;
	@Autowired
	LikeService likeservice;

	@RequestMapping("/review/bookreview")
	public String bookreview(int book_no, Model model, Paging p, HttpSession session) {
		// 책 하나 리뷰 보는 페이지로 이동(책 정보 + 리뷰정보를 가지고)
		//
		BookInfo book = null;
		List<BookInfo> bookreview = new ArrayList<BookInfo>();
		Member_tbl m = (Member_tbl) session.getAttribute("logincust");
		int result = 0;
		Like_list l = new Like_list();
		try {
			book = bookservice.get(book_no);
			p.setTotalRecord(bookservice.totalrecord(book_no));
			p.setBook_no(book_no);
			p.setStartRecord((p.getNowPage() - 1) * p.getOnePageRecord());
			System.out.println(book);
			System.out.println(p);
			bookreview = bookservice.boardPageSelect(p);
			// 찜 상태 체크..
			l.setCon_no(book.getCon_no());
			if (m != null) {
				l.setMem_no(m.getMem_no());
				result = likeservice.likeStateCheck(l);
			}

			if (result != 0) {
				// 찜 되어있는 상태이면 result=1일것
				model.addAttribute("likestate", result);
			} else {
				// 찜 되어있는 상태이면 result=0일것
				model.addAttribute("likestate", result);
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("book", book);
		model.addAttribute("bookreview", bookreview);
		model.addAttribute("p", p);
		model.addAttribute("logincust", session.getAttribute("logincust"));

		return "review/bookreview";

	}

	// 찜 삭제
	@RequestMapping("/review/likeremove")
	@ResponseBody
	public int likeremove(int mem_no, int con_no) {
		int result = 0;
		Like_list l = new Like_list();
		l.setMem_no(mem_no);
		l.setCon_no(con_no);

		try {
			likeservice.likeremove(l);
			result = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
		}
		return result;

	}

	// 찜 추가
	@RequestMapping("/review/likeadd")
	@ResponseBody
	public int likeadd(int mem_no, int con_no) {
		int result = 0;
		Like_list l = new Like_list();
		l.setMem_no(mem_no);
		l.setCon_no(con_no);
		try {
				try {
					if (likeservice.countlikelist(mem_no) <= 15) {
						//찜목록 개수 확인
						likeservice.likeadd(l);
						result = 1;
					}else {
						result= 0 ;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
}
