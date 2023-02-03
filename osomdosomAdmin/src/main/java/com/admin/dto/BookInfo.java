package com.admin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class BookInfo {
	private int book_no;
    private String bookname;
    private String authors;
    private String publisher;
    private String publication_year;
    private String isbn13;
    private String vol;
    private String class_nm;
    private String bookImageURL;
    private int con_no;
    
    //board
    private int board_no;
	private int mem_no;
	private Date writedate;
	private String title;
	private String review;
	private String partner;
	private String secret_memo;
	private int star_rate;
	
	//member_tbl
	private String nickname;
	//
}
