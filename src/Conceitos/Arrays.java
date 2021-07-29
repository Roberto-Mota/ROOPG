package Conceitos;

import gameStructure.*;
import gameStructure.GameCharacter;

public class Arrays {

	public static void main(String[] args) {

		// ---------------------------------------//

		// int[] monstersLevels;
		int[] refs = {1,2,3,4,5}; //Arrays podem ser criadas de forma mais hardcode assim
		int monstersLevels[] = new int[5]; // Precisa declarar a quantidade, detalhe que Array é um objeto e uma
											// estrutura de dados (?)
		System.out.println(monstersLevels[0]);

		// ---------------------------------------//

		monstersLevels[0] = 10;
		monstersLevels[1] = 14;
		monstersLevels[2] = 18;
		monstersLevels[3] = 11;
		monstersLevels[4] = 9;

		// ---------------------------------------//

		System.out.println(monstersLevels.length);

		for (int i = 0; i < monstersLevels.length; i++) {
			System.out.print(i + " * " + i + " = ");
			monstersLevels[i] = i * i;
			System.out.println(monstersLevels[i]);

		};
		
		// ---------------------------------------//
		
		GameCharacter monsters[] = new GameCharacter[5]; // Cria-se uma Array, porém sem nenhum objeto (null, null, null, null, null)
		
		GameCharacter spider = new GameCharacter("Spider", false); // Cria-se um objeto
		
		monsters[0] = spider; // Atribui-se a referência do objeto ao index do array	
		System.out.println(monsters[0].getNome()); // Pode acessar os métodos através da sintaxe do array
		
		GameCharacter spiderRef = monsters[0]; 
		System.out.println(spiderRef.getClass().cast(spiderRef) + " Cast da classe?"); // Estudar casting dinâmico e reflection
		System.out.println(spiderRef.getNome()); // O caminho contrário também pode ser feito. Atribuir a array com o index à nova referência.

		System.out.println();
	}

}
