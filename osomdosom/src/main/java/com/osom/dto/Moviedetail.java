package com.osom.dto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Moviedetail {
	public static MovieInfo getMoviedetail(MovieInfo Movie) throws Exception {
		// 영화코드를 가져와서 영화 상세정보 조회해보기 .. ( 장르랑 상영시간 셋팅)
		String key = "3dd3f71d384811b8ebd9a6997269cb39";
		// String key = "078796c0aaa17ffaf64385e649587bac";
		String result = "";
		URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=" + key
				+ "&movieCd=" + Movie.getMovieCd());

		BufferedReader bf;

		bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

		result = bf.readLine();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
		JSONObject movieInfoResult = (JSONObject)jsonObject.get("movieInfoResult");
		JSONObject movieInfo = (JSONObject)movieInfoResult.get("movieInfo");
		
		Movie.setShowTm((String)movieInfo.get("showTm"));
		//장르가 여러개일경우 하나로 합쳐서 저장
		JSONArray genres = (JSONArray)movieInfo.get("genres");
		JSONObject genreNm = null;
		if(genres.size()!=0) {
			String genre ="";
			genre += ((JSONObject)genres.get(0)).get("genreNm");
			for(int i=1; i<genres.size(); i++) {
				genre += ",";
				genreNm = (JSONObject)genres.get(i);
				genre += (String)genreNm.get("genreNm");
			}
			
			
			Movie.setGenreAlt(genre);
		}
		return Movie;

	}
}
