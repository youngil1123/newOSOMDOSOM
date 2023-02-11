package com.osom.ex;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.MovieInfo;
import com.osom.service.MovieService;



@SpringBootTest
class searchmovielistTests {

    @Autowired
    MovieService service;

    @Test
    void contextLoads() {
    	List<MovieInfo> objs = new ArrayList<MovieInfo>();
    	try {
			objs = service.searchmovielist("아바타");
			for(MovieInfo obj : objs) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }

}