package gameStructure;

public class Monster extends NonPlayable {
	
	public Monster(String nome, Player player, boolean NPC) { // Não herdamos o construtor, pois ele é apenas da classe
		super(nome, player, NPC);
	}

}
