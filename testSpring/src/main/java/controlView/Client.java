package controlView;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.board.BoardService;
import model.board.BoardVO;
import model.member.MemberService;
import model.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService)factory.getBean("memberService");
		BoardService bs=(BoardService)factory.getBean("boardService");
		MemberVO mvo = new MemberVO();
		BoardVO bvo = new BoardVO();
		mvo.setId("spsbsc");
		mvo.setPw("1234");
		mvo.setName("ดิดิ");
		mvo.setRole("user");
		ms.insert(mvo);
		System.out.println(ms.selectOne(mvo));
		System.out.println(ms.selectAll());
		bvo.setId(1);
		//bs.insert(bvo);
		System.out.println(bs.selectOne(bvo));
		System.out.println(bs.selectAll("gg"));
		factory.close();
	}
}
