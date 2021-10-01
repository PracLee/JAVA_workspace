package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("champ")
public abstract class Champ implements ChampAction{
	private String name;
	private List<String> inven;
	@Resource(name="bow")
	private Weapon weapon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
}
