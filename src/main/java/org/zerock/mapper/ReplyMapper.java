package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	//외래키 등록 작업
	
	public int insert(ReplyVO vo);
	
	public ReplyVO read(int bno);
	
	public int delete(int rno);
	
	public int update(ReplyVO reply);
	
	// 해당 게시물의 번호 파라미터로 전달하도록 구성
	public List<ReplyVO> getList(Criteria cri, int bno);
	
	public List<ReplyVO> getListWithPaging(
			
			@Param("cri") Criteria cri,
			@Param("bno") int bno
			);
	
	public int getCountByBno(int bno);
	
	

}
