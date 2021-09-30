package test;

public class Test {
	int a;
	public Test(){
		System.out.println("Test의 기본 생성자");
	}
	public void print() {
		System.out.println("출력할꺼당!");
	}
	public void initFunc() {
		System.out.println("멤버변수 초기화하는 코드");
		this.a=100;
	}
}
