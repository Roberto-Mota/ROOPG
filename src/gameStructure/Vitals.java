package gameStructure;

public class Vitals {
	protected double stamina = 100;
	double health = 100;
	double mana = 100;
	
	public double getStamina() {
		System.out.println("Your staminas:" + this.stamina);
		return stamina;
	}
	public void setStamina(double stamina) {
		this.stamina = stamina;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getMana() {
		return mana;
	}
	public void setMana(double mana) {
		this.mana = mana;
	}

}
