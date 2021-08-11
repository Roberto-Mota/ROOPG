package Conceitos;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ConceitosIOPrintStreamPrintWriter {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream ps = new PrintStream("savetest2.txt"); // new PrinstStream(new File("savetest2.txt"));
		/**
		* Através dessa classe, como diz o nome, vc consegue imprimir em um fluxo binário
		* 
		* O atributo System.out é do tipo PrintStream
		*/
		
		PrintWriter pw = new PrintWriter("savetest2.txt"); 
		/** A diferença é muito sútil entre as duas, porém o writer só existe pq fez parte de uma biblioteca
		 *  nova que adotou os writers (?)
		*
		* A classe PrintWriter tem métodos de mais alto nível que já cuidam de métodos, como por exemplo a nova linha,
		*  independente do sistema operacional.
		*/
		ps.println("teste");
		ps.println();
		
		ps.close();
		pw.close();

	}

}
