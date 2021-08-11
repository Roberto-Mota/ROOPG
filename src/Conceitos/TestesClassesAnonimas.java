package Conceitos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import gameStructure.Beast;
import gameStructure.Humanoid;
import gameStructure.Monster;
import gameStructure.NonPlayable;
import gameStructure.Player;

public class TestesClassesAnonimas { 
	// TestesOrdenacaoDeLista 1/3 -> Comentarios de conceitos anteriores
    // TestesClassesAnonimas  2/3 -> Conceito de classes anônimas

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
		
		
		// Isso é um Function Object (Um objeto que encapsula apenas uma função):
		
		// 1° Forma:
		// NPComparator2 comparator = new NPComparator2();
		// dungeon.sort(comparator); 
		
		//2° Forma:
		// dungeon.sort(new NPComparator2()); 
		
		/**
		 * 3° Forma (Ctrl C nervoso da classe apartir da interface, chamando o
		 * construtor sem argumentos "()", criando, por debaixo dos panos, um objeto
		 * compatível com o comparator.)
		 *
		 * Esse é o conceito de uma classe anônima, que inclusive cria uma classe com o
		 * mesmo nome dessa que está criando o objeto temporarior (?), porém com o $
		 * depois (teste$.java)
		 */

		dungeon.sort(new Comparator<NonPlayable>() {

			@Override
			public int compare(NonPlayable n1, NonPlayable n2) {
				return Integer.compare(n1.getAgility(), n2.getAgility());

			}

		});
		

		
		System.out.println("'-------'");
		System.out.println("Lista de AGI organizada:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		}
		
		
		//Outra forma de criação de classe anônima (?)
		Comparator<NonPlayable> npcNameComparator = new Comparator<NonPlayable>() { 
			@Override
			public int compare(NonPlayable n1, NonPlayable n2) {
				
				
				String NPCName1 = n1.getNome();
				String NPCName2 = n2.getNome();
				
				
				return NPCName1.compareTo(NPCName2);
				
			}
			
		};
		
		
		System.out.println("'-------'");
		System.out.println("Lista organizada em ordem alfabética:");
		for (NonPlayable nonPlayable : dungeon) {
			System.out.println(nonPlayable.getNome() + " -> AGI: " + nonPlayable.getAgility());
		
		}

	}

}