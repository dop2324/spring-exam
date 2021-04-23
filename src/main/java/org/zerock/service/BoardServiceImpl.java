package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardAttachMapper;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor

public class BoardServiceImpl implements BoardService { // 반드시 implements 를 통해서 인터페이스를 구현 해주어야 한다! 
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	
	
	@Transactional
	@Override
	public void register(BoardVO board) {
		
		log.info("register......"+board);
		
		mapper.insertSelectKey(board);
		
		if(board.getAttachList()== null|| board.getAttachList().size() <=0) {
			return;
		}
		
		board.getAttachList().forEach(attach ->{
			
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
		
	}
	
	@Transactional
	@Override
	public boolean remove(int bno) {
		
		log.info("remove...."+bno);
		
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno) == 1;
	}
	
	
	@Override
	public List<BoardAttachVO> getAttachList(int bno){
		log.info("get Attach List by bno " + bno);
		
		return attachMapper.findByBno(bno);
	}

	@Override
	public BoardVO get(int bno) {
		log.info("get......"+ bno);
		return mapper.read(bno);
	}
	
	@Transactional
	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify......"+board);
		
		attachMapper.deleteAll(board.getBno());
		
		boolean modifyResult = mapper.update(board) == 1; // mapper.update(board) =1 이면  ==1 과 같기 때문에 true를 반환한다.
		
		if(modifyResult && board.getAttachList() != null && board.getAttachList().size()>0) {
			
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;
		}

	

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("getList with Criteria: " + cri );
		
		return mapper.getListWithPaging(cri);
	}
	@Override
	public int getTotal(Criteria cri) {
		//전체 게시물의 갯수를 파악하기 위한 total 
		// 이를 활용하여 게시판 목록 갯수를 설정한다.
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	
	
	
}
