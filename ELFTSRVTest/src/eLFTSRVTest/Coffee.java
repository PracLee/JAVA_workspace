package eLFTSRVTest;

public class Coffee {
	private String coffee;
	public Coffee(String coffee) {
		this.coffee = coffee;
	}
	public String getCoffee() {
		return coffee;
	}
	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}
	@Override
	public String toString() {
		return "Coffee [coffee=" + coffee + "]";
	}
	
}
