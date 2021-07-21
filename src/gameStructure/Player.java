package gameStructure;

public class Player extends Character {
	public String classe;
	

	public Player(String nome, boolean NPC) {
		super(nome,NPC);

	}
	

	public void sleep(int time) {
		if(time == 0) {
			System.out.println("You decide to not sleep.");
		} else {
		double restoration = time * 5;
		double heal = time * 2;
		this.vitals.stamina += restoration;
		//this.vitals.health = this.getVitals().getHealth() += heal;
		System.out.println("You slept and restore " + restoration + " stamina and."); }
	}
	public void lootGold(double valor) {
		gold += valor;
	}
}
