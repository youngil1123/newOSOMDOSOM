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
class MovieKobisApplicationTests2 {

	@Autowired
	MovieService movieservice;

	@Test
	void contextLoads() {
		try {
			String page = "";
			int insertmovie = 0;
			for (int i = 207; i <=225 ; i++) {//총220 45페이지 삽입 82까지 했음 83~116 117~140 까지함 141~173 174~205 206페이지 왜안됨
				List<MovieInfo> Movies = null;
				Movies = MovieUtil2.getData(page + i, "100"); // 한번에 조회할수있는 itemPerPage가 100개까지밖에 안됨..
				System.out.println(i + "번째 :" + Movies.size());
				insertmovie += Movies.size();
				if (Movies.size() == 0)
					continue;
				else {
					for (MovieInfo Movie : Movies) {
						movieservice.register(Moviedetail.getMoviedetail(Movie));
					}
					System.out.println(i + "페이지 영화 DB 삽입중 ... ");
				}
			}
			System.out.println("영화" + insertmovie + "개 삽입 완료!!");

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
