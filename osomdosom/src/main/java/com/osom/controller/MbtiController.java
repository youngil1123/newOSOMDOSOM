package com.osom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MbtiController {


	@RequestMapping("/mbtiex")
    public String mbtiex(Model model) {
		
		model.addAttribute("top", "mbtiex");
        return "/mbti/mbtiex";
    }
	
	@RequestMapping("/mbtimain")
    public String mbtimain(Model model) {
		
		model.addAttribute("top", "mbtimain");
        return "/mbti/mbtimain";
    }
}
