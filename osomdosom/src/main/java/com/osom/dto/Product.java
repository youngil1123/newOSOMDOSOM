package com.osom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	private int pro_no;
	private String pro_name;
	private int pro_price;
	private String pro_img;
	private int pro_cnt;
};
