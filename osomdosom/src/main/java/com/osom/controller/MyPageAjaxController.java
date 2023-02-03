package com.osom.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osom.dto.Member_tbl;
import com.osom.frame.CryptoUtil;
import com.osom.service.FriendshipService;
import com.osom.service.Member_tblService;

@RestController
@RequestMapping("/mypage")
public class MyPageAjaxController {

	@Autowired
	Member_tblService mservice;

	@Autowired
	FriendshipService fservice;


	@RequestMapping("/chkDPwd")
	public String chkPwd(String thispwd, HttpServletRequest request)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		HttpSession session = request.getSession();
		Member_tbl member = (Member_tbl) session.getAttribute("logincust");
		String mypwd = member.getMem_pwd();

		String result = "no";

		try {
			String key = "osomdosompasswd0077";
			String decryptpwd = CryptoUtil.decryptAES256(mypwd, key);
			System.out.println("바뀐비번:" + decryptpwd);
			System.out.println(mypwd);
			if (decryptpwd.equals(thispwd)) {
				result = "yes";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	

}
