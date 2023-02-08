package com.osom.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.osom.dto.Member_tbl;
import com.osom.frame.CryptoUtil;
import com.osom.service.BoardService;
import com.osom.service.Member_tblService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	BoardService bservice;

	@Autowired
	Member_tblService mservice;

	@Autowired
	JavaMailSender mailSender;

	// 회원가입완료 클릭 후 넘어가는 페이지
	@GetMapping("/btn")
	public String loginForm() {
		return "login";
	}

	// 회원가입 데이터 연동
	@PostMapping("/new")
	public String create(Member_tbl member_tbl) throws Exception {
		// post로 넘어온 input 데이터를 매게변수로 입력한 MemberForm에 있는 id에 자동으로 setName 이 됨
		// 비밀번호 암호화
		String plainpwd = member_tbl.getMem_pwd();
		String key = "osomdosompasswd0077";
		String encryptpwd = CryptoUtil.encryptAES256(plainpwd, key);
		System.out.println("AES 256 방식 암호화 : " + encryptpwd);

		Member_tbl member = new Member_tbl();
		member.setMem_name(member_tbl.getMem_name());
		member.setMem_id(member_tbl.getMem_id());
		member.setMem_pwd(encryptpwd);
		member.setMem_email(member_tbl.getMem_email());
		member.setMbti(member_tbl.getMbti());
		member.setNickname(member_tbl.getNickname());
		try {
			mservice.register(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";
	}

	// 비밀번호찾기 페이지 이동
	@RequestMapping("/lostinfo")
	public String lostinfo() {
		return "lostinfo";
	}
	// 인증번호발송

	@RequestMapping(value = "/pw_auth.me")
	public ModelAndView pw_auth(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String email = (String) request.getParameter("mem_email");
		String id = (String) request.getParameter("mem_id");

		Member_tbl vo = null;
		try {
			vo = mservice.selectMember(email);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (vo != null) {
			SecureRandom r = new SecureRandom();
			int num = r.nextInt(999999); // 랜덤난수설정

			if (vo.getMem_id().equals(id)) {
				session.setAttribute("email", vo.getMem_email());

				String setfrom = "qkrgkektha@gmail.com";
				String tomail = email; // 받는사람
				String title = "[DOIT BOOK] 비밀번호변경 인증 이메일 입니다";
				String content = System.getProperty("line.separator") + "안녕하세요 회원님"
						+ System.getProperty("line.separator") + "DOIT BOOK 비밀번호찾기(변경) 인증번호는 " + num + " 입니다."
						+ System.getProperty("line.separator"); //

				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
					messageHelper.setFrom(setfrom);
					messageHelper.setTo(tomail);
					messageHelper.setSubject(title);
					messageHelper.setText(content);

					mailSender.send(message);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				ModelAndView mv = new ModelAndView();
				mv.setViewName("/pw_auth");
				mv.addObject("num", num);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView();
				mv.setViewName("/lostinfo");
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/lostinfo");
			return mv;
		}
	}

	// 인증번호 동일한지 확인
	@RequestMapping(value = "/pw_set.me", method = RequestMethod.POST)
	public String pw_set(@RequestParam(value = "email_injeung") String email_injeung,
			@RequestParam(value = "num") String num) throws IOException {
			System.out.println("일로넘오옴");
			System.out.println(email_injeung+num);
		if (email_injeung.equals(num)) {
			return "pw_new";
		} else {
			return "/lostinfo";
		}
	} // 이메일 인증번호 확인

	
	/*
	 * //DB 비밀번호 업데이트
	 * 
	 * @RequestMapping(value = "/pw_new.me", method = RequestMethod.POST ) public
	 * String pw_new(Member_tbl vo, HttpSession session , HttpServletRequest
	 * request) throws IOException{ String plainpwd =
	 * (String)request.getParameter("pw"); String key = "osomdosompasswd0077";
	 * String encryptpwd =null; try { encryptpwd =
	 * CryptoUtil.encryptAES256(plainpwd, key);
	 * System.out.println("AES 256 방식 암호화 : " + encryptpwd); } catch
	 * (InvalidKeyException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } catch (UnsupportedEncodingException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } catch
	 * (NoSuchAlgorithmException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } catch (NoSuchPaddingException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } catch
	 * (InvalidAlgorithmParameterException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } catch (IllegalBlockSizeException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } catch (BadPaddingException
	 * e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * vo.setMem_pwd(encryptpwd); int result = mservice.pwUpdate_M(vo); if(result ==
	 * 1) { return "login"; } else { System.out.println("pw_update"+ result); return
	 * "pw_new"; }
	 */
}
