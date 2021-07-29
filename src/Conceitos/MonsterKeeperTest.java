package Conceitos;

import gameStructure.GameCharacter;
import gameStructure.Player;

public class MonsterKeeperTest { // Um conceito simplificado do que o ArrayList faz

	public static void main(String[] args) {
		MonsterKeeper Keeper = new MonsterKeeper();

		        GameCharacter cc = new Player("Kormok", true);
		        Keeper.add(cc);
		        
				int size = Keeper.getElementsQtd();
		        System.out.println(size);
		        
		        GameCharacter ref = Keeper.getRef(0);
		        System.out.println(ref.getNome());
		    }
		

	}


