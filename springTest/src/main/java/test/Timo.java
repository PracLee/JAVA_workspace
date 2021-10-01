package test;

import org.springframework.stereotype.Component;

@Component("timo")
public class Timo extends Champ{

	@Override
	public void attack() {
		this.getWeapon().attack();
		// 널포인터익셉션 발생 우려가있으니, new 했어야 했다!
		// -> 멤버변수로 처리, 생서자 주입
		// -> setter 주입으로 변경 (기본생성자가 필요!)
	}

	@Override
	public void print() {
		System.out.println("name");
		for(String v : this.getInven()) {
			System.out.println(v);
		}
	}
	
}
