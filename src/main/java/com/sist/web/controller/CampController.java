package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.entity.CampEntity;
import com.sist.web.service.CampService;
import com.sist.web.vo.CampListVO;
@Controller
public class CampController {
	@Autowired
	private CampService cService;
	
	@GetMapping("/") 
	public String camp_main(@RequestParam(name="page",required = false) String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=(rowSize*curpage);
		
		List<CampListVO> list=cService.campListData(start, end);
		int totalpage=cService.CampTotalpage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		 
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalpage",totalpage);
		model.addAttribute("main_html","main/home");
		return "index";
	}
	
	@GetMapping("/detail")
	public String camp_detail(@RequestParam("cno") int cno, Model model)
	{
		CampEntity vo=cService.campDetailData(cno);
		model.addAttribute("vo",vo);
		model.addAttribute("main_html","camp/detail");
		 
		return "index"; 
	}
}
