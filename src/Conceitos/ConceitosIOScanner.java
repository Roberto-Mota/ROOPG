package Conceitos;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class ConceitosIOScanner {

	public static void main(String[] args) throws IOException {


		Scanner scanner = new Scanner(new File("saves.csv"));
		// ArrayList<String> lista = new ArrayList<String>();
		
		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine(); //Pega a pr�xima linha do meu arquivo
			Scanner linhaScanner = new Scanner(linha); //N�o podemos usar o mesmo scanner de antes pq o scanner tem apenas uma funcionalidade aplicavel (?)
			linhaScanner.useDelimiter(","); //no scanner o regex pode ser alcan�ado atrav�s do m�todo useDelimiter
			
			String valor1 = linhaScanner.next(); //cada next tem um tipo primitivo com parsing autom�tico
			String valor2 = linhaScanner.next();
			String valor3 = linhaScanner.next();
			String valor4 = linhaScanner.next();
			String valor5 = linhaScanner.next();
			
			String valorFormatado = String.format("Level: %s Classe: %s Life: %s Teste: %s - %s", valor1, valor2, valor3, valor4, valor5); //O primeiro parametro define o formato, depois os par�metros
			System.out.println(valorFormatado); //O que t� dentros do primeiro par�metro de format � como vai ficar o print
			
			/**
			 * Quando se l� um arquivo dessa forma, pode haver problemas de leitura de regionalismo, como quando, por exemplo,
			 * no Brasil se usa a v�rgula para se dividir as casas decimais. Esse padr�o tamb�m � transportado para os OS,
			 * o que pode acarretar em problemas de leitura, geralmente InputMismatchException, pra resolver esse problema,
			 * temos que ser expl�citos quanto a que regras nosso c�digo utiliza, n�o permitindo com que o Scanner pergunte
			 * qual os padr�es do OS do usu�rio. o m�todo para fazer isso: useLocale();
			 */

			linhaScanner.useLocale(Locale.US); //Locale � uma classe que utiliza atributos est�ticos
			
			linhaScanner.close();
			/**
			* String[] valores = linha.split(","); //Recebe um regex, resumidademente um regex � a regra de separa��o de informa��es
			* System.out.println(valores[3]);
			* Classe Arrays � uma fachada, como Collections, porem para arrays
			*/
		}
		
		
		

	}

}
