package Conceitos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConceitosIOEntradaArquivos { // Estabelecendo a entrada

	public static void main(String[] args) throws IOException{

		/*
		 * Arquivos, Rede, Teclado etc. podem ser fluxos de entrada para a aplica��o
		 * Arquivos, Rede, Console etc. podem ser fluxos de sa�da
		 * 
		 * Como estabelecer um fluxo de entrada com um arquivo:
		 */

		
			FileInputStream fis = new FileInputStream("savetest.txt");
			// Aqui � necess�rio fazer o tratamento de exce��o checked
			// Caso contr�rio, n�o compila
			
			/**
			 * Essa classe, por mais que leia Inputs, ela � de muito naixo n�vel,
			 * o m�todo .read por exemplo l� streams de bits e bytes
			 * Por isso ser� necess�rio uma outra classe para melhorar nosso input, transformando isso em caracteres:
			 */
			
			InputStreamReader irs = new InputStreamReader(fis); 
			//Ele precisa de uma inst�ncia de um tipo de input stream para saber como interpretar
			
			/**
			 * Essa classe possui a capacidade de transformar bit e bytes em caracteres,
			 *  como se fosse um n�vel um pouco mais alto do que o fis, por�m
			 *  para acessarmos um arquivo de forma de mais altio n�vel, pre-
			 *  cisamos de uma outra classe que possui a capacidade de guardar os caracteres
			 *  at� preencher uma linha, para isso cria-se um buffer:
			 */
			
			BufferedReader br = new BufferedReader(irs);
			//O par�metro se faz necess�rio novamente
			//Essa classe j� possui o par�metro de ler uma linha
			
			
			/**
			 * Essa pr�tica de embrulhar uma fun��o na outra � chamado de "decorator", pois
			 * uma classe "decora" a fun��o da outra e replica utilizando mais m�todos.
			 * O output � semelhante pois usa dos mesmos conceitos
			 */
			
			//-------------------------------------------------------------------------------//
			
			
			String linha = br.readLine(); //Com o m�todo da classe br podemos ler linhas
			// Esse m�todo precisa de tratamento de IOException,
			// que � um maior que o FileNotFoundException (pode trocar no main)
			
			/**
			 * Sysout para imprimir essa linha, para ter uma sa�da, sendo que o
			 *  sysout escreve automaticamente para o fluxo de sa�da (para o console)
			 */
			
			while (linha !=null) {
				System.out.println(linha);
				linha = br.readLine();
			}
				
			
			//Pra terminar bonitinho temos que fechar o BufferedReader:
			br.close();
			

			
			
			
		
		
	}
}