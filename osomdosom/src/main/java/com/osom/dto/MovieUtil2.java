package com.osom.dto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieUtil2 {
	public static List<MovieInfo> getData(String curPage, String itemPerPage) throws Exception {
		
		String key = "3dd3f71d384811b8ebd9a6997269cb39";
		// String key = "078796c0aaa17ffaf64385e649587bac";
		//파싱한 데이터를 저장할 변수
		
		String result = "";
		URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key="
    				+ key + "&curPage="+ curPage + "&itemPerPage=" + itemPerPage + "&openStartDt=2000&openEndDt=2023");
		
		BufferedReader bf;
		
		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		
		result = bf.readLine();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
		JSONObject movieListResult = (JSONObject)jsonObject.get("movieListResult");
		JSONArray movieList = (JSONArray)movieListResult.get("movieList");
		List<MovieInfo> ml = new ArrayList<MovieInfo>();
		// ======== 조회한 영화목록들을 MovieInfo 객체에 셋팅 ==============
		JSONObject Onemovie = null;
		for(int i = 0; i<movieList.size(); i++){
			MovieInfo Movie = new MovieInfo();
			Onemovie =  (JSONObject)movieList.get(i);
			//성인물이 너무 많은데 빼고싶다
			String genrecheck = (String)Onemovie.get("genreAlt");
			if(genrecheck.contains("성인물(에로)")) continue;
			if(Onemovie.get("typeNm").equals("장편")&&Onemovie.get("prdtStatNm").equals("개봉")){
				//장편영화랑 개봉된 영화만 넣자
				JSONArray directors = (JSONArray)Onemovie.get("directors");
				JSONObject directors_peopleNm = null;
				if(directors.size()!= 0) {
					//감독란이 비어있을경우 비워두기
					directors_peopleNm = (JSONObject)directors.get(0);
					Movie.setPeopleNm((String)directors_peopleNm.get("peopleNm"));
				}else {
					Movie.setPeopleNm(null);
				}
	
			    Movie.setMovieCd((String)Onemovie.get("movieCd"));
			    Movie.setMovieNm((String)Onemovie.get("movieNm"));
			    Movie.setMovieNmEn((String)Onemovie.get("movieNmEn"));
			    Movie.setGenreAlt((String)Onemovie.get("genreAlt"));
			    Movie.setOpenDt((String)Onemovie.get("openDt")); 
			    ml.add(Movie);
		}
	}

		return ml;
	}
}
