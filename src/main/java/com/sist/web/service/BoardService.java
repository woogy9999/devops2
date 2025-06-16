package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardVO;

public interface BoardService {
	
	public BoardEntity boardDetailData(int no);
	public Map boardListData(int page);
	public void boardInsert(BoardEntity vo);
	public int maxNo();
}
