package com.osom.frame;

import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {
	public static void saveFile(MultipartFile mf, String memimgdir) throws Exception { // 파일 덩어리를 사용자에게 넣어라...라는뜻
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			
			FileOutputStream fo2 = 
					new FileOutputStream(memimgdir+imgname);
			fo2.write(data);
			fo2.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//
	}
	
}
