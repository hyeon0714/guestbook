package com.javaex.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
//@RestController 이걸 사용하면 responsebody를 쓰지 않아도 된다
public class GuestbookController {
	
	@Autowired
	private GuestbookService gs;
	
	//삭제
	@ResponseBody
	@DeleteMapping(value = "/list/{no}")	//@deletemapping은 리퀘스트 메소드를 delete로 고정한다
	public int delete(@RequestBody GuestbookVo gv, 
						@PathVariable("no")int no) {//뷰를 이용해서 파라미터값을 받을때는 @PathVariable을 사용한다
		System.out.println("del");
		gv.setNo(no);
		System.out.println(gv);
		
		int count = gs.exeDelete(gv);
		return count;
	}
	
	//저장
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public GuestbookVo add(@RequestBody GuestbookVo gv) {
		
		System.out.println("Add");
		
		System.out.println(gv);
		
		GuestbookVo guest = gs.exeAdd(gv);
		
		return guest;
	}
	
	
	//리스트 가져오기
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<GuestbookVo> list() {
		
		System.out.println("controller");
		
		List<GuestbookVo> gList = gs.exeList();
		
		System.out.println(gList);
		
		return gList;
	}
}
