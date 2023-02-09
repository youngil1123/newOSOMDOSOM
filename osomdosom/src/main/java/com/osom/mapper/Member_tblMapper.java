package com.osom.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.osom.dto.Board;
import com.osom.dto.Member_tbl;
import com.osom.dto.Paging;
import com.osom.frame.MyMapper;

@Mapper
@Repository
public interface Member_tblMapper extends MyMapper<String,Member_tbl>{
	public Integer findmem_no(String mem_id);
	public String findid(String mem_name, String mem_email);
	public String findpwd(String mem_id, String mem_email);
	public Integer idCheck(String mem_id);

	public List<Member_tbl> selectallfollower(Integer myNo) throws Exception;

	public void updateMyInfo(int mem_no, String mem_pwd, String nickname, String mbti, String mem_img, String myword);
	public void updatePoint(int mem_no) throws Exception;
	
	public Object findByMemberEmail(String mem_email);

	public Member_tbl selectMember(String mem_email);
	
	public Member_tbl selectbyno (Integer mem_no);
	
	public void pwUpdate_M(String mem_id, String mem_pwd, String mem_email);
<<<<<<< HEAD
	public void logindate(int mem_no, String today);
=======
	public int totalRecord(int mem_no);//멤버의 리뷰 수
	public List<Board> boardPageSelect(Paging p);//페이징해서 리뷰 가져가기
>>>>>>> branch 'main' of https://github.com/youngil1123/newOSOMDOSOM.git
	
}
