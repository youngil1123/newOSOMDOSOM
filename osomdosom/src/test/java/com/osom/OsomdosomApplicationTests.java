package com.osom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.service.MbtiService;

@SpringBootTest
class OsomdosomApplicationTests {
	 @Autowired 
	    MbtiService mservice;

	    @Test
	    void contextLoads() {
	    	int mbtimemno=mservice.countmbtimemno("isfp");
	    	System.out.println(mbtimemno);
		
	    }

}
