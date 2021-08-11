package Conceitos;

import java.io.FileWriter;
import java.io.IOException;


public class ConceitosIOFileWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("savetest3.txt");
		
		/**
		 * FileWriter pode ser combinado com outros Writers, como BufferedWriter.
		 * Writer bw = new BufferedWriter(new FileWriter("arquivo.txt"));
		 */
		
		fw.write("Lorem ipsum dolor sit amet!");
		fw.write("\r\n"); //Como o FileWriter não tem o método newline precisamos usar o caracter especial (um para o windows e outro pra mac (?)
		fw.write(System.lineSeparator()); //Método estatico que devolve o caracter especial de acordo com o OS
		fw.write("test");
		
		fw.close();
	}

}
