package org.zerock.mapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	/*
	 * @Test public void testGetList() { mapper.getList().forEach(board ->
	 * log.info(board)); }
	 * 
	 * @Test public void testInsert() {
	 * 
	 * BoardVO board = new BoardVO(); board.setTitle("안녕하세요");
	 * board.setContent("새로 작성하는 내용"); board.setWriter("newbie");
	 * 
	 * mapper.insert(board);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testInsertSelectKey() {
	 * 
	 * BoardVO board = new BoardVO(); board.setTitle("안녕하세요 select key");
	 * board.setContent("새로 작성하는 내용 select key"); board.setWriter("newbie");
	 * 
	 * mapper.insertSelectKey(board);
	 * 
	 * log.info(board);
	 * 
	 * }
	 * 
	 * @Test public void testRead() {
	 * 
	 * // 존재하는 게시물 번호로 테스트 BoardVO board = mapper.read(2);
	 * 
	 * log.info(board); }
	 * 
	 * @Test public void testDelete() { log.info("DELETE COUNT: " +
	 * mapper.delete(3)); }
	 * 
	 * @Test public void testUpdate() {
	 * 
	 * BoardVO board = new BoardVO(); //실행전 존재하는 번호인지 확인 할 것 board.setBno(5);
	 * board.setTitle("수정된 제목"); board.setContent("수정된 내용"); board.setWriter("이동형");
	 * 
	 * int count = mapper.update(board); log.info("UPDATE COUNT:" + count); }
	 */
	/*
	 * @Test public void testPaging() {
	 * 
	 * Criteria cri = new Criteria();
	 * 
	 * cri.setPageNum(1); cri.setAmount(10);
	 * 
	 * List<BoardVO> list = mapper.getListWithPaging(cri);
	 * 
	 * list.forEach(board -> log.info(board));
	 * 
	 * }
	 */
	@Test
	public void testSearch() {
		
		Criteria cri = new Criteria();
		cri.setKeyword("안녕");
		cri.setType("T");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
}













