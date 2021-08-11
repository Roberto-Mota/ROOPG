package Conceitos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConceitosIOEntradaArquivos { // Estabelecendo a entrada

	public static void main(String[] args) throws IOException{

		/*
		 * Arquivos, Rede, Teclado etc. podem ser fluxos de entrada para a aplicação
		 * Arquivos, Rede, Console etc. podem ser fluxos de saída
		 * 
		 * Como estabelecer um fluxo de entrada com um arquivo:
		 */

		
			FileInputStream fis = new FileInputStream("savetest.txt");
			// Aqui é necessário fazer o tratamento de exceção checked
			// Caso contrário, não compila
			
			/**
			 * Essa classe, por mais que leia Inputs, ela é de muito naixo nível,
			 * o método .read por exemplo lê streams de bits e bytes
			 * Por isso será necessário uma outra classe para melhorar nosso input, transformando isso em caracteres:
			 */
			
			InputStreamReader irs = new InputStreamReader(fis); 
			//Ele precisa de uma instância de um tipo de input stream para saber como interpretar
			
			/**
			 * Essa classe possui a capacidade de transformar bit e bytes em caracteres,
			 *  como se fosse um nível um pouco mais alto do que o fis, porém
			 *  para acessarmos um arquivo de forma de mais altio nível, pre-
			 *  cisamos de uma outra classe que possui a capacidade de guardar os caracteres
			 *  até preencher uma linha, para isso cria-se um buffer:
			 */
			
			BufferedReader br = new BufferedReader(irs);
			//O parâmetro se faz necessário novamente
			//Essa classe já possui o parâmetro de ler uma linha
			
			
			/**
			 * Essa prática de embrulhar uma função na outra é chamado de "decorator", pois
			 * uma classe "decora" a função da outra e replica utilizando mais métodos.
			 * O output é semelhante pois usa dos mesmos conceitos
			 */
			
			//-------------------------------------------------------------------------------//
			
			
			String linha = br.readLine(); //Com o método da classe br podemos ler linhas
			// Esse método precisa de tratamento de IOException,
			// que é um maior que o FileNotFoundException (pode trocar no main)
			
			/**
			 * Sysout para imprimir essa linha, para ter uma saída, sendo que o
			 *  sysout escreve automaticamente para o fluxo de saída (para o console)
			 */
			
			while (linha !=null) {
				System.out.println(linha);
				linha = br.readLine();
			}
				
			
			//Pra terminar bonitinho temos que fechar o BufferedReader:
			br.close();
			

			
			
			
		
		
	}
}