package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.CampRepository;
import com.sist.web.entity.CampEntity;
import com.sist.web.vo.CampListVO;

@Service
public class CampServiceImpl implements CampService {

	@Autowired
	private CampRepository cDao;
	@Override
	public List<CampListVO> campListData(int start, int end) {
		// TODO Auto-generated method stub
		return cDao.campListData(start, end);
	}

	@Override
	public CampEntity campDetailData(int cno) {
		// TODO Auto-generated method stub
		return cDao.findByCno(cno);
	}

	@Override
	public int campTotalpage() {
		// TODO Auto-generated method stub
		int count=(int)cDao.count();
		return (int)(Math.ceil(count/12.0));
	}
	
}
