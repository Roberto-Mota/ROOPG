
public class Beast extends NonPlayable { //heran�as m�ltiplas n�o podem ser feitas no Java, mas em outras linguagens sim (Python por exemplo)

	public Beast(String nome, Player player, boolean NPC) { //N�o herdamos o construtor, pois ele � apenas da classe
		super(nome, player, NPC);
	}
}