package gameStructure;

public class Player extends Character {
	
	private int classe; //00 -> warrior, 01 -> rogue, 02 -> mage
	

	public Player(String nome, boolean NPC) {
		super(nome,NPC);

	}
	
	public void sleep(int time) {
		if(time == 0) {
			System.out.println("You decide to not sleep.");
		} else {
		double restoration = time * 5;
		double heal = time * 2;
		this.vitals.health += heal;
		this.vitals.stamina += restoration;
		this.getVitals().setHealth(heal);
		System.out.println("You slept and restore " + restoration + " stamina and."); }
	}
	public void lootGold(double valor) {
		gold += valor;
	}
}
