package gameStructure;

public abstract class NonPlayable extends GameCharacter{
	
	protected double XpPool = 25.0 * this.getLevel();

	public NonPlayable(String nome, Player player, boolean NPC) {
		super(nome, player, NPC);
		
	}
	
	





}

//XpPool receberia alguma coisa ligada ao level do mob
