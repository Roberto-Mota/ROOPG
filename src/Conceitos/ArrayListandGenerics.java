package Conceitos;

import java.util.ArrayList;
import java.util.List;

import gameStructure.NonPlayable;

public class ArrayListandGenerics {
	public static void main(String[] args) {
		
	
	
	// Arrays falham em ser demasiadamente estáticos, para trabalhar com uma lista mais dinâmica é preciso usar outro caminho
	ArrayList<NonPlayable> lista = new ArrayList<NonPlayable>(); // os <> são os "Generics", espécies de filtros para que essa array
																	//list apenas aceite esse tipo de classe
	
																// ArrayLists são sobrecarregados e podem receber o tamnho da lista
	
	ArrayList novaLista = new ArrayList(lista); //criando baseado na primeira lista
	
	for (Object oRef : lista) { // "Pra cada elemento object na lista"
		System.out.println(oRef);
		
		// Ao avaliar dois objetos em uma lista, ou um objeto fora com um de dentro, Correto, devemos sobrescrever o método equals para definir a igualdade do objeto.
			//Em geral, os métodos equals, toString e hashCode existem para sobrescrita.
	}
	// List (superclass da ArrayList), não trabalha com tipos primitivos, porém o java faz um truque por de baixo dos panos
	// Para isso ele transforma o Int primitivo em uma classe (Integer é a classe do int)

}
}
