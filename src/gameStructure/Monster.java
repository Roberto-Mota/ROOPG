package gameStructure;

public class Monster extends NonPlayable {
	
	public Monster(String nome, Player player, boolean NPC) { // N�o herdamos o construtor, pois ele � apenas da classe
		super(nome, player, NPC);
	}

}
