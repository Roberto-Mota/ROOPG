
public class Beast extends NonPlayable { //heranças múltiplas não podem ser feitas no Java, mas em outras linguagens sim (Python por exemplo)

	public Beast(String nome, Player player, boolean NPC) { //Não herdamos o construtor, pois ele é apenas da classe
		super(nome, player, NPC);
	}
}