package model;

import java.util.ArrayList;

public class CommentReply {
	private CommentVO c;
	private ArrayList<ReplyVO> rList;
	public CommentVO getC() {
		return c;
	}
	public void setC(CommentVO c) {
		this.c = c;
	}
	public ArrayList<ReplyVO> getrList() {
		return rList;
	}
	public void setrList(ArrayList<ReplyVO> rList) {
		this.rList = rList;
	}
	@Override
	public String toString() {
		return "CommentReply [c=" + c + ", rList=" + rList + "]";
	}

}
