package gameStructure;

public class Humanoid extends NonPlayable {
	
	public Humanoid(String nome, Player player, boolean NPC) { // N�o herdamos o construtor, pois ele � apenas da classe
		super(nome, player, NPC);
	}

}