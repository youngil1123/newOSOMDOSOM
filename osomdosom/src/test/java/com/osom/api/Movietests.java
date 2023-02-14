package com.osom.api;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.dto.MovieInfo;
import com.osom.dto.MovieUtil2;
import com.osom.dto.Moviedetail;
import com.osom.service.MovieService;

@SpringBootTest
class Movietests {

	@Autowired
	MovieService movieservice;

	@Test
	void contextLoads() {
		try {
			List<MovieInfo> Movies = null;
			Movies = MovieUtil2.getData("206", "100");
			for (MovieInfo Movie : Movies) {
				movieservice.register(Moviedetail.getMoviedetail(Movie));
				System.out.println("완료");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
