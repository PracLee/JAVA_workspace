package model;

public class CommentVO {
	private int cNum;
	private String com;
	private String ID;
	private String PW;
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
		return "commentVO [cNum=" + cNum + ", com=" + com + ", ID=" + ID + ", PW=" + PW + "]";
	}

}
