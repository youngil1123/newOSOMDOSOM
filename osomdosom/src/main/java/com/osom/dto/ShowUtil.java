package com.osom.dto;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ShowUtil {
	//tag값의 정보를 가져오는 메소드
	public static List<TheaterInfo> getShowdetail(List<String> idlist) throws Exception{
		String url = "http://www.kopis.or.kr/openApi/restful/pblprfr";
		String key = "3ae262eecb7546baaa3eb7b89e2d818e";
		// String key = "b310ade5b9ca4bebba5950dc7788f3eb";
		String decodeServiceKey = URLDecoder.decode(key,"UTF-8");
		List<TheaterInfo> theaters = new ArrayList<TheaterInfo>();
		for(String id : idlist) {
			TheaterInfo theater = new TheaterInfo();
			theater.setMt20id(id);
			Document documentInfo = DocumentBuilderFactory
					.newInstance()
					.newDocumentBuilder()
					.parse(url + "/" + id + "?service=" + decodeServiceKey);
			documentInfo.getDocumentElement().normalize();
			// System.out.println("Root element :" +documentInfo.getDocumentElement());
			
			NodeList nList = documentInfo.getElementsByTagName("db");
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					theater.setPrfnm(TagParser.getTagValue("prfnm", eElement));
					theater.setGenrenm(TagParser.getTagValue("genrenm", eElement));
					theater.setPrfpdfrom(TagParser.getTagValue("prfpdfrom", eElement));
					theater.setPrfpdto(TagParser.getTagValue("prfpdto", eElement));
					theater.setPoster(TagParser.getTagValue("poster", eElement));
					theater.setFcltynm(TagParser.getTagValue("fcltynm", eElement));
					theater.setPrfstate(TagParser.getTagValue("prfstate", eElement));
					theater.setPrfruntime(TagParser.getTagValue("prfruntime", eElement));
				}
				System.out.println(theater);
			
			}
			theaters.add(theater);
		}
		return theaters;
	}
	public static List<String> getShowlist(String cpage,String rows) throws Exception{
		//연극과 뮤지컬 리스트id들만 가져오기 
		String url = "http://www.kopis.or.kr/openApi/restful/pblprfr";
		String key = "3ae262eecb7546baaa3eb7b89e2d818e";
		// String key = "b310ade5b9ca4bebba5950dc7788f3eb";
		String decodeServiceKey = URLDecoder.decode(key,"UTF-8");
		String shcate = "GGGA"; //장르코드 AAAA(연극) GGGA(뮤지컬)
		cpage = (cpage == null)? "1" : cpage; //현재페이지(필수)
		rows = (rows == null)? "100" : rows; //페이지당 목록 수(필수)
		Document documentInfo = DocumentBuilderFactory
				.newInstance()
				.newDocumentBuilder()
				.parse(url + "?service=" + decodeServiceKey 
						+"&stdate=20000000&eddate=20231231&cpage="
						+cpage+"&rows="+rows+"&shcate="+shcate);
		documentInfo.getDocumentElement().normalize();
		//System.out.println("Root element :" +documentInfo.getDocumentElement());
		
		NodeList nList = documentInfo.getElementsByTagName("db");
		System.out.println("파싱할 데이터수:" +nList.getLength());
		List<String> tl = new ArrayList<String>();
		
		for(int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element)nNode;
				String state = TagParser.getTagValue("prfstate", eElement);
				if(state.equals("공연중")||state.equals("공연완료")) {
					tl.add(TagParser.getTagValue("mt20id", eElement));
				}
				/*
				 * System.out.println("===================");
				 * System.out.println("공연ID: "+TagParser.getTagValue("mt20id",eElement));
				 * System.out.println("공연명: "+TagParser.getTagValue("prfnm",eElement));
				 * System.out.println("공연장르: "+TagParser.getTagValue("genrenm",eElement));
				 * System.out.println("공연상태: "+TagParser.getTagValue("prfstate", eElement));
				 * System.out.println("공연시작일: "+TagParser.getTagValue("prfpdfrom", eElement));
				 * System.out.println("공연종료일: "+TagParser.getTagValue("prfpdto", eElement));
				 * System.out.println("공연포스터경로: "+TagParser.getTagValue("poster", eElement));
				 * System.out.println("공연장명: "+TagParser.getTagValue("fcltynm", eElement));
				 */
			}
		}
		return tl;
	}
}
