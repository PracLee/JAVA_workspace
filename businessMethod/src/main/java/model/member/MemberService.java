package model.member;

import java.util.ArrayList;

public interface MemberService {
	public void insertMem(MemberVO vo);
	public void updateMem(MemberVO vo);
	public void deleteMem(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
	public ArrayList<MemberVO> selectAll();
}
