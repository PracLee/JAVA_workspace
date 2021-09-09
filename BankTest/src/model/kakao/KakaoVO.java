package model.kakao;

public class KakaoVO {
	private int account;
	private String name;
	private int balance;
	@Override
	public String toString() {
		return "KakaoVO [account=" + account + ", name=" + name + ", balance=" + balance + "]";
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
