package com.osom.dto;

public class Criteria {
	
	private int PageNum =1;
	private int number = 10;
	
	
	public int getPageStart() {
		return (this.PageNum -1) * number;
	}
	
	public int getPageEnd() {
		return this.PageNum * number;
	}

	public void setAmount(int i) {
		// TODO Auto-generated method stub
		
	}
	

}
