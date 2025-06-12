package com.sist.web.service;

import java.util.List;

import com.sist.web.entity.CampEntity;
import com.sist.web.vo.CampListVO;


public interface CampService {


	public List<CampListVO> campListData(int start, int end);
	public CampEntity campDetailData(int cno);
	public int CampTotalpage();
	
}
