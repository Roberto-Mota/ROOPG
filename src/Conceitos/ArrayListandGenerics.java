package Conceitos;

import java.util.ArrayList;
import java.util.List;

import gameStructure.NonPlayable;

public class ArrayListandGenerics {
	public static void main(String[] args) {
		
	
	
	// Arrays falham em ser demasiadamente est�ticos, para trabalhar com uma lista mais din�mica � preciso usar outro caminho
	ArrayList<NonPlayable> lista = new ArrayList<NonPlayable>(); // os <> s�o os "Generics", esp�cies de filtros para que essa array
																	//list apenas aceite esse tipo de classe
	
																// ArrayLists s�o sobrecarregados e podem receber o tamnho da lista
	
	ArrayList novaLista = new ArrayList(lista); //criando baseado na primeira lista
	
	for (Object oRef : lista) { // "Pra cada elemento object na lista"
		System.out.println(oRef);
		
		// Ao avaliar dois objetos em uma lista, ou um objeto fora com um de dentro, Correto, devemos sobrescrever o m�todo equals para definir a igualdade do objeto.
			//Em geral, os m�todos equals, toString e hashCode existem para sobrescrita.
	}
	// List (superclass da ArrayList), n�o trabalha com tipos primitivos, por�m o java faz um truque por de baixo dos panos
	// Para isso ele transforma o Int primitivo em uma classe (Integer � a classe do int)

}
}
