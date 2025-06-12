package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.CampEntity;
import com.sist.web.vo.CampListVO;

@Repository
public interface CampRepository extends JpaRepository<CampEntity, Integer>{
	@Query(value="SELECT cno,title,poster,num "
			+ "FROM (SELECT cno,title,poster,rownum as num "
			+ "FROM (SELECT cno,title,poster "
			+ "FROM CAMP ORDER BY cno ASC)) "
			+ "WHERE num BETWEEN :start AND :end",nativeQuery = true)
	public List<CampListVO> campListData(@Param("start") int start, @Param("end") int end);
	
	public CampEntity findByCno(int cno);
	

}
