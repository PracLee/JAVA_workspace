package model.board;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService bs = (BoardService)factory.getBean("boardService");
		System.out.println(bs.getAll());
		factory.close();
	}
}
