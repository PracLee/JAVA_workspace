package model;

public class CommentVO {
	private int cNum;
	private String com;
	private String ID;
	private String PW;
	private int replyCnt;
	private int likeCnt;
	
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public String getCom() {
		return com;
	}
	public void setCom(String com) {
		this.com = com;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	@Override
	public String toString() {
		return "CommentVO [cNum=" + cNum + ", com=" + com + ", ID=" + ID + ", PW=" + PW + ", replyCnt=" + replyCnt
				+ ", likeCnt=" + likeCnt + "]";
	}
	

}
