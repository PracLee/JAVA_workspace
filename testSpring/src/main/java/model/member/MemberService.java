package model.member;

import java.util.List;

public interface MemberService {
	public MemberVO selectOne(MemberVO vo);
	public List<MemberVO> selectAll();
	public void insert(MemberVO vo);
	public void update(MemberVO vo);
	public void delete(MemberVO vo);
}
