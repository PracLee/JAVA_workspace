package model.board;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService bs = (BoardService)factory.getBean("boardService");
		BoardVO vo = new BoardVO();
		vo.setId(1);
		vo.setTitle("ÀÔ·ÂÁß");
		bs.getOne(vo);
		System.out.println(bs.getAll());
		factory.close();
	}
}
