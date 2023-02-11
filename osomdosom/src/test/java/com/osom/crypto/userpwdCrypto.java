package com.osom.crypto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.osom.frame.CryptoUtil;

@SpringBootTest
class userpwdCrypto {

	@Test
	void contextLoads() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String plainpwd = "저으니도와줘~";
		System.out.println("회원가입시 작성한 비밀번호 : "+plainpwd);
		
		String key = "osomdosompasswd0077";
		
		String enStr = CryptoUtil.encryptAES256(plainpwd, key);
		System.out.println("AES 256 방식 암호화 :" + enStr);
		
		String deStr = CryptoUtil.decryptAES256(enStr, key);
		System.out.println("AES 256 방식 복호화 :" + deStr);
		
	}
	

}
