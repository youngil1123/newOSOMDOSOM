package com.osom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.osom.dto.Mail;
import com.osom.dto.Member_tbl;
import com.osom.frame.MyService;
import com.osom.mapper.BoardMapper;
import com.osom.mapper.Member_tblMapper;

@Service
public class Member_tblService implements MyService<String, Member_tbl> {

	@Autowired
	Member_tblMapper mapper;
	
	@Autowired
	BoardMapper bmapper;
	
    @Autowired
	 private JavaMailSender mailSender;
	
	//회원가입
	@Override
	public void register(Member_tbl v) throws Exception {
		mapper.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
	}

	@Override
	public void modify(Member_tbl v) throws Exception {
		mapper.update(v);
	}

	@Override
	public Member_tbl get(String k) throws Exception {
		return mapper.select(k);
		
	}

	@Override
	public List<Member_tbl> get() throws Exception {
		return mapper.selectall();
	}
	
	public List<Member_tbl> getfollower(Integer myNo) throws Exception {
		return mapper.selectallfollower(myNo);
	}
	
	public int idCheck(String mem_id) {
		int cnt = mapper.idCheck(mem_id);
		System.out.println("cnt: " + cnt);
		return cnt;
	}	

	public String findid(String mem_name, String mem_email) {
		return mapper.findid(mem_name, mem_email);
	}

	public String findpwd(String mem_id, String mem_email) {
		return mapper.findpwd(mem_id, mem_email);
	}

	public Integer findmem_no(String mem_id) {
		
		return mapper.findmem_no(mem_id);
	}

	public void updateMyInfo(int mem_no, String mem_pwd, String nickname, String mbti, String mem_img, String myword) {
		mapper.updateMyInfo(mem_no, mem_pwd, nickname, mbti, mem_img, myword);
	}

	

	public void updatePoint(int mem_no) throws Exception {
		 mapper.updatePoint(mem_no);
	    }


	// 메일 내용을 생성하고 임시 비밀번호로 회원 비밀번호를 변경
	public Mail createMailAndChangePassword(String mem_email) {
		String str = getTempPassword();
		Mail dto = new Mail();
		dto.setAddress(mem_email);
		dto.setTitle("Cocolo 임시비밀번호 안내 이메일 입니다.");
		dto.setMessage("안녕하세요. doit book의 임시비밀번호 안내 관련 이메일 입니다." + " 회원님의 임시 비밀번호는 " + str + " 입니다."
						+ "로그인 후에 비밀번호를 변경을 해주세요");
		updatePassword(str, mem_email);
			return dto;
		}

			// 임시 비밀번호로 업데이트
			/*
			 * public void updatePassword(String str, String mem_email) { Member_tbl member
			 * = (Member_tbl) mapper.findByMemberEmail(mem_email); String mem_id =
			 * member.getMem_id(); String mem_pwd = member.getMem_pwd();
			 * mapper.updatePassword(mem_id, mem_pwd); }
			 */
			// 랜덤함수로 임시비밀번호 구문 만들기

	  public void updatePassword(String str, String mem_email){
	        String mem_pwd = str;
	        String mem_id = mapper.findByMemberEmail(mem_email).toString();
	        mapper.updatePassword(mem_id,mem_pwd);
	    }

	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
						'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
						'Z' };

		String str = "";

				// 문자 배열 길이의 값을 랜덤으로 10개를 뽑아 구문을 작성함
			int idx = 0;
			for (int i = 0; i < 10; i++) {
				idx = (int) (charSet.length * Math.random());
				str += charSet[idx];
			}
			return str;
		}
			// 메일보내기

	public void mailSend(Mail mailDTO) {
		System.out.println("전송 완료!");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailDTO.getAddress());
		message.setSubject(mailDTO.getTitle());
		message.setText(mailDTO.getMessage());
		message.setFrom("qkrgkektha@gmail.com");
		message.setReplyTo("qkrgkektha@gmail.com");
		System.out.println("message" + message);
		mailSender.send(message);

			}

			// 비밀번호 변경

			public void updatePassWord(String mem_id, String mem_pwd) {
				mapper.updatePassword(mem_id, mem_pwd);
			}


		
}



	

