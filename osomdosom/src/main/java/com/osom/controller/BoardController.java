package com.osom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

//github.com/youngil1123/OSOMDOSOM.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.osom.dto.Board;
import com.osom.dto.Member_tbl;
import com.osom.service.BoardService;
import com.osom.service.Member_tblService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BoardController {

	@Autowired
	BoardService boardservice;

	
	@Autowired
	Member_tblService mservice;

		// 내 글 보기
		@RequestMapping("/myboard")
		public String searchmylist(Model model,  HttpSession session) throws Exception{
			List<Board> list = null;
			Member_tbl member = new Member_tbl();
			member = (Member_tbl)session.getAttribute("logincust");


			if(member != null) {
					int mem_no = member.getMem_no();
					list = boardservice.searchmylist(mem_no);
			}
			
			model.addAttribute("searchmylist", list);

			return "board/myboard";	
		}

		//게시글 등록
	@RequestMapping(value="/board/create_action",  method = RequestMethod.POST)		//작성된 게시글 등록 기능 메소드, html의 form 태그 action에서 입력한 주소
    public String insert(@ModelAttribute Board board, HttpSession session) throws Exception{
    	
		/* Integer.parseInt(board.getCon_no()); */
		Member_tbl member = null;
        member = (Member_tbl)session.getAttribute("logincust");
        int mem_no=member.getMem_no();
        board.setMem_no(mem_no);
		
		
    	System.out.println(board);
    	boardservice.register(board);
    	mservice.updatePoint(mem_no);
    	return "redirect:/myboard";	//내 글 페이지로 이동
    }
	
	// 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final int board_no, Model model) {
        Board board = boardservice.findPostById(board_no);
        model.addAttribute("board", board);
        return "board/boardView";
    }
    
    @GetMapping("/post/fwview.do")
    public String openFwPostView(@RequestParam final int board_no, Model model) {
        Board board = boardservice.findPostById(board_no);
        model.addAttribute("board", board);
        return "follower/fwBoardView";
    }
	
    // 게시글 수정
	
	  @RequestMapping(value = "/update_action", method = RequestMethod.POST)
	  public String updatePost(Board board, Model model) throws Exception {
	 
		  System.out.println(board);
	 boardservice.updatePost(board);
	  
	  return "redirect:/myboard"; }
	 

	
	
	
	// 게시글 삭제
    @PostMapping("/post/delete.do")
    public String deletePost(@RequestParam final int board_no) {
        try {
			boardservice.deletePost(board_no);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        return "redirect:/myboard";
    }

    }
	

