package model.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("mService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mdao;
	@Override
	public void insertMem(MemberVO vo) {
		mdao.insertBoard(vo);
		
	}

	@Override
	public void updateMem(MemberVO vo) {
		mdao.updateBoard(vo);
	}

	@Override
	public void deleteMem(MemberVO vo) {
		mdao.deleteBoard(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		// TODO Auto-generated method stub
		return mdao.getOne(vo);
	}

	@Override
	public ArrayList<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return mdao.getAll();
	}

}
