package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.dto.Admin;
import com.admin.frame.MyService;
import com.admin.mapper.AdminMapper;

@Service
public class AdminService implements MyService<Integer, Admin> {

	@Autowired
	AdminMapper mapper;
	@Override
	public void register(Admin v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Admin v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin get(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public int adminlogin(Admin adm) throws Exception{
		return mapper.adminlogin(adm);
	}

}
