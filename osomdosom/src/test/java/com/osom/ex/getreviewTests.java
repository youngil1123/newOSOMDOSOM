package com.osom.ex;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.Paging;
import com.osom.dto.TheaterInfo;
import com.osom.service.TheaterService;



@SpringBootTest
class getreviewTests {

	@Autowired
	TheaterService theaterserivce;
	
	@Test
    void contextLoads() {
		TheaterInfo theater = null;
		Paging p = new Paging();
		List<TheaterInfo> theaterreview = new ArrayList<TheaterInfo>();
		try {
			theater = theaterserivce.get("PF122116");
			p.setMt20id("PF122116");
			p.setGenrenm("뮤지컬");
			p.setTotalRecord(theaterserivce.totalRecord(p));
			p.setStartRecord((p.getNowPage()-1)*p.getOnePageRecord());
			System.out.println(theater);
			System.out.println(p);
			theaterreview = theaterserivce.boardPageSelect(p);
			System.out.println(theaterreview);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}