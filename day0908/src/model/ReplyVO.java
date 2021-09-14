package model;

public class ReplyVO {
	private int rnum;
	private String rid;
	private int cnum;
	private String rom;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	@Override
	public String toString() {
		return "ReplyVO [rnum=" + rnum + ", rid=" + rid + ", cnum=" + cnum + ", rom=" + rom + "]";
	}
	
}
