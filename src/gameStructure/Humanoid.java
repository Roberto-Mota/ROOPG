package gameStructure;

public class Humanoid extends NonPlayable {
	
	public Humanoid(String nome, Player player, boolean NPC) { // Não herdamos o construtor, pois ele é apenas da classe
		super(nome, player, NPC);
	}

}