package Conceitos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import gameStructure.Beast;
import gameStructure.Humanoid;
import gameStructure.Monster;
import gameStructure.NonPlayable;
import gameStructure.Player;

public class TestesOrdenacaoDeListas {
	/**
	 * Nessa aula fundamental e importante aprendemos que:
	 *
	 * para ordenar uma lista � preciso definir um crit�rio de ordena��o h� duas
	 * formas de definir esse crit�rio: (pela interface Comparator pela interface
	 * Comparable (ordem natural))
	 * 
	 * O algoritmo de ordena��o j� foi implementado na lista no m�todo sort e na classe 
	 * Collections pelo m�todo sort a classe
	 * 
	 * Collections � uma fachada com v�rios m�todos auxiliares para trabalhar com as
	 * cole��es, principalmente listas
	 */

	public static void main(String[] args) {
		Player player1 = new Player("Kormok", false);

		// Dei um hardcode nos nomes por que ainda preciso resolver a gera��o rand�mica dos mesmos
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
		
		NPComparator comparator = new NPComparator();
		dungeon.sort(comparator); // N�o funciona sozinho, precisa do comparator, que estabelece o crit�rio de
							// ordena��o
		
		System.out.println("'-------'");
		System.out.println("Lista de AGI organizada:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}
		
		//NPCNameComparator nameComparator = new NPCNameComparator();
		//dungeon.sort(nameComparator); //O comparador como par�metro estabelece a forma de organizar
		
		//Forma mais enxuta de utilizar uma referencia apenas uma vez em um par�metro:
		dungeon.sort(new NPCNameComparator());
		
		/**
		 * A vers�o legado de organizar listas:
		 *  Collections.sort(list, comparator);
		 *  Collections � uma classe "de fachada", pois possui v�rios m�todos est�ticos (nao muito orientado a objeto)
		 */
		
		System.out.println("'-------'");
		System.out.println("Lista organizada em ordem alfab�tica:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
			
		/**
		 * Um outro caminho que posso seguir � implementar Comparable<Generics> na minha classe, o que torna
		 * a classe compar�vel (comparator != comparable), sendo que a base de compara��o ser� a 
		 * ordem natural.
		 * 
		 * A ordem natural � definida pelo pr�prio elemento da lista e se d� pelo m�todo compareTo(Object o),
		 *  que deve ser sobescrito quando implementar o Comparable.
		 *  
		 *  A classe Arrays � parecida com Collections no sentido que tamb�m junta v�rios m�todos utilit�rios
		 */
		}

	}

}

// Criar uma classe que implementa o comparator para conseguir usar o sort
class NPComparator implements Comparator<NonPlayable> {

	@Override
	public int compare(NonPlayable n1, NonPlayable n2) { // O crit�rio � criado aqui e cabe ao desenvolvedor criar o
															// mesmo
		/**
		 * O retorno do compare diz sobre a equival�ncia dos objetos parametrizados,
		 * sendo: -1 : n1 < n2 0 : n1 == n2 +1 : n1 > n2
		 * 
		 * O n�mero positivo e negativo n�o � importante, por tanto que carregue consigo
		 * o sinal de pos. ou neg. O resto da organiza��o o comparator faz sozinho (?)
		 */

		/**
		 * Vers�o mais expl�cita dos retornos: 
		 * 
		 * if (n1.getAgility() < n2.getAgility()) 
		 * { return -1; }
		 *
		 * if (n1.getAgility() > n2.getAgility())
		 * { return 1; } 
		 * 
		 * return 0;
		 */
		
		
		/**
		* Vers�o mais enxuta, que entrega os mesmos resultados:
		* 
		* (se der negativo, devolve valor negativo, e assim por diante):
		* return n1.getAgility() - n2.getAgility();
		*/
		
		// Uma terceira vers�o, que utiliza o Wrapper:
		 return Integer.compare(n1.getAgility(), n2.getAgility());
		 
		
	}

}

class NPCNameComparator implements Comparator<NonPlayable> { // Aqui farei um comparator baseado em String

	@Override
	public int compare(NonPlayable n1, NonPlayable n2) {
		
		//antes � necess�rio descobrir o nome dos monstros
		String NPCName1 = n1.getNome();
		String NPCName2 = n2.getNome();
		
		//A classe String j� possui um m�todo que compara characteres para organizar uma lista
		
		return NPCName1.compareTo(NPCName2);
		
		//J� pode colocar como retorno pq esse m�todo segue o mesmo principio do compare,
		//	onde retorna valores pos., neg. e 0 para organizar
	}
	
}
