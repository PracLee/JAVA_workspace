package test;

import org.springframework.stereotype.Component;

@Component("timo")
public class Timo extends Champ{

	@Override
	public void attack() {
		this.getWeapon().attack();
		// ���������ͼ��� �߻� �����������, new �߾�� �ߴ�!
		// -> ��������� ó��, ������ ����
		// -> setter �������� ���� (�⺻�����ڰ� �ʿ�!)
	}

	@Override
	public void print() {
		System.out.println("name");
		for(String v : this.getInven()) {
			System.out.println(v);
		}
	}
	
}
