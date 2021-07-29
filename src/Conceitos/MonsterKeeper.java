package Conceitos;

import gameStructure.GameCharacter;

public class MonsterKeeper { //Conceito da classe ArrayList do java.util

	    private GameCharacter listaRef[]; //cria o array referencias
	    private int posicaoLivre;


	    public MonsterKeeper() {
	        this.listaRef = new GameCharacter[10];
	    }

		public void add(GameCharacter personagem) {
		        listaRef[this.posicaoLivre] = personagem;
		        this.posicaoLivre++;
		    }

		public int getElementsQtd() {
			return this.posicaoLivre;
		}
		
		


		public GameCharacter getRef(int pos) {
	        return this.listaRef[pos];
			// recuperar determinado elemento do guardador a partir de uma posição
		}

			
		}

	

