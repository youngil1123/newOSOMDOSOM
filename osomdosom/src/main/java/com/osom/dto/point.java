package com.osom.dto;

import java.sql.Date;

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
public class point {
	private int p_number; 
	private String mem_id;
	private int p_point;
	private Date p_pointdate;
	private String p_type;
}
