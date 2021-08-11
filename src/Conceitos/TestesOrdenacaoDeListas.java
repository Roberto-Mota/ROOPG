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
	 * para ordenar uma lista é preciso definir um critério de ordenação há duas
	 * formas de definir esse critério: (pela interface Comparator pela interface
	 * Comparable (ordem natural))
	 * 
	 * O algoritmo de ordenação já foi implementado na lista no método sort e na classe 
	 * Collections pelo método sort a classe
	 * 
	 * Collections é uma fachada com vários métodos auxiliares para trabalhar com as
	 * coleções, principalmente listas
	 */

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
		
		NPComparator comparator = new NPComparator();
		dungeon.sort(comparator); // Não funciona sozinho, precisa do comparator, que estabelece o critério de
							// ordenação
		
		System.out.println("'-------'");
		System.out.println("Lista de AGI organizada:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}
		
		//NPCNameComparator nameComparator = new NPCNameComparator();
		//dungeon.sort(nameComparator); //O comparador como parâmetro estabelece a forma de organizar
		
		//Forma mais enxuta de utilizar uma referencia apenas uma vez em um parâmetro:
		dungeon.sort(new NPCNameComparator());
		
		/**
		 * A versão legado de organizar listas:
		 *  Collections.sort(list, comparator);
		 *  Collections é uma classe "de fachada", pois possui vários métodos estáticos (nao muito orientado a objeto)
		 */
		
		System.out.println("'-------'");
		System.out.println("Lista organizada em ordem alfabética:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
			
		/**
		 * Um outro caminho que posso seguir é implementar Comparable<Generics> na minha classe, o que torna
		 * a classe comparável (comparator != comparable), sendo que a base de comparação será a 
		 * ordem natural.
		 * 
		 * A ordem natural é definida pelo próprio elemento da lista e se dá pelo método compareTo(Object o),
		 *  que deve ser sobescrito quando implementar o Comparable.
		 *  
		 *  A classe Arrays é parecida com Collections no sentido que também junta vários métodos utilitários
		 */
		}

	}

}

// Criar uma classe que implementa o comparator para conseguir usar o sort
class NPComparator implements Comparator<NonPlayable> {

	@Override
	public int compare(NonPlayable n1, NonPlayable n2) { // O critério é criado aqui e cabe ao desenvolvedor criar o
															// mesmo
		/**
		 * O retorno do compare diz sobre a equivalência dos objetos parametrizados,
		 * sendo: -1 : n1 < n2 0 : n1 == n2 +1 : n1 > n2
		 * 
		 * O número positivo e negativo não é importante, por tanto que carregue consigo
		 * o sinal de pos. ou neg. O resto da organização o comparator faz sozinho (?)
		 */

		/**
		 * Versão mais explícita dos retornos: 
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
		* Versão mais enxuta, que entrega os mesmos resultados:
		* 
		* (se der negativo, devolve valor negativo, e assim por diante):
		* return n1.getAgility() - n2.getAgility();
		*/
		
		// Uma terceira versão, que utiliza o Wrapper:
		 return Integer.compare(n1.getAgility(), n2.getAgility());
		 
		
	}

}

class NPCNameComparator implements Comparator<NonPlayable> { // Aqui farei um comparator baseado em String

	@Override
	public int compare(NonPlayable n1, NonPlayable n2) {
		
		//antes é necessário descobrir o nome dos monstros
		String NPCName1 = n1.getNome();
		String NPCName2 = n2.getNome();
		
		//A classe String já possui um método que compara characteres para organizar uma lista
		
		return NPCName1.compareTo(NPCName2);
		
		//Já pode colocar como retorno pq esse método segue o mesmo principio do compare,
		//	onde retorna valores pos., neg. e 0 para organizar
	}
	
}
