package model.user;

public class UserVO {
	private String ID;
	private String PW;
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
		return "UserVO [ID=" + ID + ", PW=" + PW + "]";
	}
	
}
