package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.admin.dto.Member_tbl;
import com.admin.service.AdminService;
import com.admin.service.BoardService;
import com.admin.service.BookService;
import com.admin.service.Member_tblService;
import com.admin.service.MovieService;
import com.admin.service.TheaterService;

@RestController
public class MainAjaxController {

	@Autowired
	
	AdminService aservice;

	@Autowired
	Member_tblService mservice;
	
	@Autowired
	BoardService bservice;
	
	@Autowired
	MovieService movieservice;
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	TheaterService theaterservice;

	
}
