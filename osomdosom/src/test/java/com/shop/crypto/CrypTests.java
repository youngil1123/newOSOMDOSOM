package com.shop.crypto;

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
class CrypTests {

	@Test
	void contextLoads() throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String plainText = "pwd01";

		System.out.println("원본 데이터 : " + plainText);
		String enc_plainText = CryptoUtil.sha512(plainText);
		System.out.println("SHA-512방식 암호화 " + enc_plainText);
		
		String plainText2 = "pwd01";
		String enc_plainText2 = CryptoUtil.sha512(plainText2);
		
		if(enc_plainText.equals(enc_plainText2)) {
			System.out.println("OK");
		}
		
		
		System.out.println("-------------------------------------------------");
		
		String key = "osomdosompasswd0077";
		
		String enStr = CryptoUtil.encryptAES256(plainText, key);
		System.out.println("AES 256 방식 암호화 : " + enStr);
		
		String deStr = CryptoUtil.decryptAES256(enStr, key);
		System.out.println("AES 256 방식 복호화 :" + deStr);
		
	}
	

}
