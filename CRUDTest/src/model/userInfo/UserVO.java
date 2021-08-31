package model.userInfo;

public class UserVO {
	private String ID;
	private String PW;
	private boolean admin;
	@Override
	public String toString() {
		return "UserVO [ID=" + ID + ", PW=" + PW + ", admin=" + admin + "]";
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
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
