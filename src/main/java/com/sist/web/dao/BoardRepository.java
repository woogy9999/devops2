package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.BoardVO;

import java.util.*;
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,name,subject,content,regdate,hit,rownum as num "
			+ "FROM (SELECT no,name,subject,content,regdate,hit "
			+ "FROM yhw_board ORDER BY no DESC)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	public BoardEntity findByNo(int no);

	
    // Sequence 
    @Query(value="SELECT NVL(MAX(no)+1,1) FROM yhw_board",nativeQuery = true)
    public int maxNo();
    // save , count , delete 
}
