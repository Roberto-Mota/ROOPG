package Conceitos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import gameStructure.Beast;
import gameStructure.Humanoid;
import gameStructure.Monster;
import gameStructure.NonPlayable;
import gameStructure.Player;

public class TesteLambdas { 
	// TestesOrdenacaoDeLista 1/3 -> Comentarios de conceitos anteriores
    // TestesClassesAnonimas  2/3 -> Conceito de classes anônimas
	// TestesLambdas		  3/3 -> Conceitos do Lambda

	public static void main(String[] args) {
		Player player1 = new Player("Kormok", false);

		// Dei um hardcode nos nomes por que ainda preciso resolver a geração randômica dos mesmos
		NonPlayable monster1 = new Monster("Zombie", player1, true);
		NonPlayable humanoid1 = new Humanoid("Soldier", player1, true);
		NonPlayable beast1 = new Beast("Wolf", player1, true);

		NonPlayable monster2 = new Monster("Slime", player1, true);
		NonPlayable humanoid2 = new Humanoid("Goblin", player1, true);
		NonPlayable beast2 = new Beast("Spider", player1, true);

		List<NonPlayable> dungeon = new ArrayList<>();
		
		dungeon.add(monster1);
		dungeon.add(humanoid1);
		dungeon.add(beast1);

		dungeon.add(monster2);
		dungeon.add(humanoid2);
		dungeon.add(beast2);
		
		System.out.println("Lista de AGI desorganizada:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}

		// Apaga uma parcela da classe anônima até o método em si e jogando a setinha após os parâmetros:
		dungeon.sort( (NonPlayable n1, NonPlayable n2) -> {
				return Integer.compare(n1.getAgility(), n2.getAgility());
			}
		);
		/** Que magia foi essa?
		 * Primeiro foram definidos os parâmetros, ou seja, a entrada "()";
		 * A setinha que define o código associado a entrada "->";
		 * O código que será executado com os parâmetros de entrada "{}";
		 * 
		 * Por baixo dos panos, o java cria uma classe anônima, implementa a interface comparator e usa o método compare
		 */
		

		
		System.out.println("'-------'");
		System.out.println("Lista de AGI organizada:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}
		
		
		//Outra forma de criação de classe anônima (?)
		//Apagar tudo além dos parâmetros
		Comparator<NonPlayable> npcNameComparator = (NonPlayable n1, NonPlayable n2) -> {

			String NPCName1 = n1.getNome();
			String NPCName2 = n2.getNome();

			return NPCName1.compareTo(NPCName2);
		};
		
		//Uma outra utilidade do Lambda:
		
		//O método foreach() executa a ação fornecida para cada elemento do Iterable até que
		// todos os elementos tenham sido processados ​​ou até que a ação lance uma exceção.
		// Este, diferententemente, usa a interface "Consumer"
		
		// Alguns tweaks: Pode tirar a tipacao da entrada do metodo, pois a lista já esta com generics
		//				  não são necessarias chaves por esta lidando com apenas uma linha de codigo
		
		dungeon.forEach((np1) -> System.out.println(np1.getNome() + " -> AGI: " + np1.getAgility()));
		
		//equivalente a:
		System.out.println("'-------'");
		System.out.println("Lista organizada em ordem alfabética:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}

	}

}