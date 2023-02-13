package com.osom.mbti;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Board;
import com.osom.dto.Mbti;
import com.osom.service.BoardService;
import com.osom.service.MbtiService;

@SpringBootTest
class Top5tests {

	@Autowired
	MbtiService mservice;
	@Autowired
	BoardService bservice;

	@Test
	void contextLoads() {
		List<Board> list = new ArrayList<Board>();
		list = bservice.getTop5("도서");
		List<Mbti> books = new ArrayList<Mbti>();
		for (Board o : list) {
			// conno 가지고 정보 가져오기.
			Mbti m = null;
			int con_no = o.getCon_no();
			m = mservice.getconByconnoBook(con_no);
			m.setConStar_rate(o.getConStar_rate());
			m.setCon_no(con_no);
			books.add(m);
		}
		for(Mbti mo : books) {
			System.out.println(mo);
		}
		//

	}
}