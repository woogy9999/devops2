package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardVO;
/*
 *   DAO => 데이터베이스 연동 
 *   Service => 로직 처리 ===> BI 
 *   Controller => Service에서 결과값을 받아서 브라우저에 전송하는 역할 
 *   
 *                               CI / CD  => DevOps
 *                                                      | => Docker (저장공간 => 컨테이너)
 *   Git ============> Repository에 저장 =====> jar  ==========> AWS전송 .jar
 *       commit/push     감지                 실행파일로 변경          |
 *                                           Git Action          jar파일이 들어오는 경우 실행 
 *                                           deploy.yml         java -jar de.....jar
 */
import com.sist.web.entity.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;
// boot에서 웹 개발 => 프레임워크를 그대로 사용 : 어노테이션 사용이 가능 
@Service
public class BoardServiceImpl implements BoardService{
    // 주소 읽기 => 스프링 (메모리 할당)
	@Autowired
	private BoardRepository bDao;
	
	@Override
	public BoardEntity boardDetailData(int no) {
		// TODO Auto-generated method stub
		// 조회수 증가 
		BoardEntity vo=bDao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bDao.save(vo);
		// 증가된 데이터 읽기 
		vo=bDao.findByNo(no);
		return vo;
	}

	// 보내는 데이터가 여러개 => Map
	@Override
	public Map boardListData(int page) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<BoardVO> list=bDao.boardListData(start, end);
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/10.0));
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		return map;
	}

	@Override
	public void boardInsert(BoardEntity vo) {
		// TODO Auto-generated method stub
		vo.setHit(0);
		vo.setRegdate(new Date());
		vo.setNo(maxNo());
		
		bDao.save(vo);
		
	}
	
	public int maxNo()
	{
		return bDao.maxNo();
	}

}