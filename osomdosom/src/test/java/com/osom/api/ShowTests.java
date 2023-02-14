package com.osom.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.ShowUtil;
import com.osom.dto.TheaterInfo;
import com.osom.service.TheaterService;

@SpringBootTest
class ShowTests {

	@Autowired
	TheaterService theaterservice;
	@Test
	void contextLoads() {
		try {
			String page ="";
			int insertobj = 0;
			List<String> ids = null;
			for(int i = 92; i<=120; i++) { //연극 1~7 8~100 121까지 (완료) 
										  //뮤지컬 끝 112까지
				ids=ShowUtil.getShowlist(page+i,"100");
				
				List<TheaterInfo> objs = null;
				objs = ShowUtil.getShowdetail(ids);
				System.out.println(i + "번째페이지 :" + ids.size());
				insertobj += ids.size();
				if(ids.size() == 0) continue;
				else {
					for(TheaterInfo obj : objs) {
						theaterservice.register(obj);
					}
					System.out.println(i + "페이지 영화 db 삽입완료");
				}
			}
			System.out.println("뮤지컬" + insertobj + "개 db 삽입 완료!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
