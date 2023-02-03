package com.admin.dto;

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
public class Admin {
	private int admin_no;
	private String admin_id;
	private String admin_pwd;
	
	public Admin(String admin_id, String admin_pwd) {
		this.admin_id = admin_id;
		this.admin_pwd = admin_pwd;
	}
	
}
