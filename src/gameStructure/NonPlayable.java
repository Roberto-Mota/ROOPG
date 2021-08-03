package gameStructure;

import java.util.Random;

public abstract class NonPlayable extends GameCharacter{
	
	Random rand = new Random();
	
	protected Double XpPool = Double.valueOf((double) 20 * rand.nextInt(this.getLevel()));


	public NonPlayable(String nome, Player player, boolean NPC) {
		super(nome, player, NPC);
		
	}
	
	
	





}

//XpPool receberia alguma coisa ligada ao level do mob
