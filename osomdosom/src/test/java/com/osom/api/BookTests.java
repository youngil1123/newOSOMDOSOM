package com.osom.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.BookInfo;
import com.osom.dto.BookUtil;
import com.osom.service.BookService;

@SpringBootTest
class BookTests {
	@Autowired
	BookService bookservice;

	@Test
	void contextLoads() {
		try {
			String page = "";
			int insertobj = 0;
			List<BookInfo> books = null;
			for (int i = 1; i <= 50; i++) {
				books = BookUtil.getBookList(i + page, "100");
				System.out.println(i + "번째 페이지:" + books.size());
				insertobj += books.size();
				if (books.size() == 0)
					continue;
				else {
					for (BookInfo book : books) {
						bookservice.register(book);
					}
					System.out.println(i + "페이지 책 db삽입완료");
				}
			}
			System.out.println("책" + insertobj + "개 db 삽입 완료!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
