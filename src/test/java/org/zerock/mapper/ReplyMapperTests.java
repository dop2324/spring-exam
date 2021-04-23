package org.zerock.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	
	//게시글 테스트 번호 
	/* private int[] bnoArr = {1,2,4,5,6,7,8,9}; */
	
	/*
	 * @Test public void testCreate() {
	 * 
	 * IntStream.rangeClosed(1, 10).forEach(i -> { ReplyVO vo = new ReplyVO();
	 * 
	 * //게시물 번호 vo.setBno(bnoArr[i % 5]); vo.setReply("댓글 테스트" + i);
	 * vo.setReplyer("댓글적은 사람" + i);
	 * 
	 * mapper.insert(vo); }); }
	 * 
	 * 
	 * @Test public void testMapper() {
	 * 
	 * log.info(mapper); }
	 */
	/*
	 * @Test public void testRead() { int targetRno = 5;
	 * 
	 * ReplyVO vo = mapper.read(targetRno);
	 * 
	 * log.info(vo); }
	 */
	
	@Test
	public void testList2() {
		
		Criteria cri = new Criteria(2,10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 2);
		
		replies.forEach(reply -> log.info(reply));
	}

}
