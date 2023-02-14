package com.osom.dto;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookUtil {

	public static List<BookInfo> getBookList(String pageNo, String pageSize) throws Exception {
		String url = "http://data4library.kr/api/loanItemSrch";
		String key = "c63704ecffe538ac84fb75c2593719b579d3ecd1e7b59f1da929bd4b062227ba";
		String decodeServiceKey = URLDecoder.decode(key, "UTF-8");
		pageNo = (pageNo == null)? "1" : pageNo; //현재페이지(필수)
		pageSize = (pageSize == null)? "100" : pageSize; //페이지당 목록 수(필수)
		Document documentInfo = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(url + "?authKey="
				+ decodeServiceKey + "&startDt=2022-01-01&endDt=2022-03-31&pageNo=" + pageNo + "&pageSize=" + pageSize);
		documentInfo.getDocumentElement().normalize();
		List<BookInfo> books = new ArrayList<BookInfo>();
		NodeList nList = documentInfo.getElementsByTagName("doc");
		System.out.println("파싱할 데이터수:" + nList.getLength());
		for(int temp = 0; temp < nList.getLength(); temp++) {
			BookInfo book = new BookInfo();
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				book.setBook_no(Integer.parseInt(TagParser.getTagValue("no", eElement)));
				book.setBookname(TagParser.getTagValue("bookname", eElement));
				book.setAuthors(TagParser.getTagValue("authors", eElement));
				book.setPublisher(TagParser.getTagValue("publisher", eElement));
				book.setPublication_year(TagParser.getTagValue("publication_year", eElement));
				book.setIsbn13(TagParser.getTagValue("isbn13", eElement));
				book.setVol(TagParser.getTagValue("vol", eElement));
				book.setClass_nm(TagParser.getTagValue("class_nm", eElement));
				book.setBookImageURL(TagParser.getTagValue("bookImageURL", eElement));
				/*
				 * System.out.println("==========================");
				 * System.out.println("도서순번:"+TagParser.getTagValue("no", eElement));
				 * System.out.println("도서명:"+TagParser.getTagValue("bookname", eElement));
				 * System.out.println("저자명:"+TagParser.getTagValue("authors", eElement));
				 * System.out.println("출판사:"+TagParser.getTagValue("publisher", eElement));
				 * System.out.println("출판년도:"+TagParser.getTagValue("publication_year",eElement)); 
				 * System.out.println("ISBN13:"+TagParser.getTagValue("isbn13",eElement)); 
				 * System.out.println("권:"+TagParser.getTagValue("vol", eElement));
				 * System.out.println("주제분류:"+TagParser.getTagValue("class_nm", eElement));
				 * System.out.println("책표지URL:"+TagParser.getTagValue("bookImageURL",eElement));
				 */
			}
			books.add(book);
		}
		return books;
	}
}
