package com.osom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Friendship {
	private int friend_no;
	private int mem_no;
	private int mem_no2;
	
	Friendship(int mem_no, int mem_no2){
		super();
		this.mem_no =mem_no;
		this.mem_no2 = mem_no2;
		
	}
}
