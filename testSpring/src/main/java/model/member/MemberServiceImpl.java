package model.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO mdao;
	
	@Override
	public MemberVO selectOne(MemberVO vo) {
		return mdao.getOne(vo);
	}

	@Override
	public List<MemberVO> selectAll() {
		return mdao.getAll();
	}

	@Override
	public void insert(MemberVO vo) {
		mdao.insertBoard(vo);
	}

	@Override
	public void update(MemberVO vo) {
		mdao.updateBoard(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		mdao.deleteBoard(vo);
	}

}
