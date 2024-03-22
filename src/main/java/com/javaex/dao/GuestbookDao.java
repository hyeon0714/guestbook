package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;
	
	//삭제
	public int delete(GuestbookVo gv) {
		
		return sqlSession.delete("guestbook.delete", gv);
	}
	
	//추가하고 번호받기
	public int add(GuestbookVo gv) {
		
		sqlSession.insert("guestbook.insertSelectKey", gv);
		
		return gv.getNo();		
	}
	
	//한개 가져오기
	public GuestbookVo exeSelect(int no) {
		
		GuestbookVo guest = sqlSession.selectOne("guestbook.selectOne", no);
		
		return guest;
	}
	
	//리스트 가져오기
	public List<GuestbookVo> list() {
		System.out.println("dao");
		
		List<GuestbookVo> gList = sqlSession.selectList("guestbook.selectList");
		
		return gList;
	}
}
