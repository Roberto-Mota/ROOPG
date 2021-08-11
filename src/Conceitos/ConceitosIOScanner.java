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
			String linha = scanner.nextLine(); //Pega a próxima linha do meu arquivo
			Scanner linhaScanner = new Scanner(linha); //Não podemos usar o mesmo scanner de antes pq o scanner tem apenas uma funcionalidade aplicavel (?)
			linhaScanner.useDelimiter(","); //no scanner o regex pode ser alcançado através do método useDelimiter
			
			String valor1 = linhaScanner.next(); //cada next tem um tipo primitivo com parsing automático
			String valor2 = linhaScanner.next();
			String valor3 = linhaScanner.next();
			String valor4 = linhaScanner.next();
			String valor5 = linhaScanner.next();
			
			String valorFormatado = String.format("Level: %s Classe: %s Life: %s Teste: %s - %s", valor1, valor2, valor3, valor4, valor5); //O primeiro parametro define o formato, depois os parâmetros
			System.out.println(valorFormatado); //O que tá dentros do primeiro parâmetro de format é como vai ficar o print
			
			/**
			 * Quando se lê um arquivo dessa forma, pode haver problemas de leitura de regionalismo, como quando, por exemplo,
			 * no Brasil se usa a vírgula para se dividir as casas decimais. Esse padrão também é transportado para os OS,
			 * o que pode acarretar em problemas de leitura, geralmente InputMismatchException, pra resolver esse problema,
			 * temos que ser explícitos quanto a que regras nosso código utiliza, não permitindo com que o Scanner pergunte
			 * qual os padrões do OS do usuário. o método para fazer isso: useLocale();
			 */

			linhaScanner.useLocale(Locale.US); //Locale é uma classe que utiliza atributos estáticos
			
			linhaScanner.close();
			/**
			* String[] valores = linha.split(","); //Recebe um regex, resumidademente um regex é a regra de separação de informações
			* System.out.println(valores[3]);
			* Classe Arrays é uma fachada, como Collections, porem para arrays
			*/
		}
		
		
		

	}

}
