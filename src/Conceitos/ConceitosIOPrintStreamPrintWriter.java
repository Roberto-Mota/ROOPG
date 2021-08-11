package Conceitos;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ConceitosIOPrintStreamPrintWriter {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("savetest2.txt"); // new PrinstStream(new File("savetest2.txt"));
		/**
		* Atrav�s dessa classe, como diz o nome, vc consegue imprimir em um fluxo bin�rio
		* 
		* O atributo System.out � do tipo PrintStream
		*/
		
		PrintWriter pw = new PrintWriter("savetest2.txt"); 
		/** A diferen�a � muito s�til entre as duas, por�m o writer s� existe pq fez parte de uma biblioteca
		 *  nova que adotou os writers (?)
		*
		* A classe PrintWriter tem m�todos de mais alto n�vel que j� cuidam de m�todos, como por exemplo a nova linha,
		*  independente do sistema operacional.
		*/
		ps.println("teste");
		ps.println();
		
		ps.close();
		pw.close();

	}

}
