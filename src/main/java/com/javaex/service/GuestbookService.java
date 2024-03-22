package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao gd;
	
	//삭제
	public int exeDelete(GuestbookVo gv) {
		
		return gd.delete(gv);
	}
	
	//추가후 1개 가져오기
	public GuestbookVo exeAdd(GuestbookVo gv) {
		
		gd.add(gv);
		
		int no = gd.add(gv);
		
		return gd.exeSelect(no);
	}
	
	//리스트 가져오기
	public List<GuestbookVo> exeList() {
		System.out.println("service");
		
		return gd.list();
		
	}
}
