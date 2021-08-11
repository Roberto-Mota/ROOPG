package Conceitos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ConceitosIOSaidaArquivo {

	public static void main(String[] args) throws IOException{
		//Fluxo de saida com arquivo
		// Conceitos básicos do decorator estão nos conceitos de entrada
		

		
		InputStream fis = System.in; //FileInputStream('arquivo.txt');
		//O system.in é o teclado (agora tudo faz sentido, agora as peças se encaixaram!)
		InputStreamReader irs = new InputStreamReader(fis); 
		BufferedReader br = new BufferedReader(irs);
		
		OutputStream fos = System.out; //FileOutputStream("savetestkeyboard.txt"); //System.out (o console)
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
//		bw.write("level:1;classe:Mage;xp:2548");
//		bw.newLine();
//		bw.write("teste linhas");
		
		String linha = br.readLine();
		
		while(linha != null) {
			if (linha.isEmpty()) {
				System.out.println("Deseja encerrar? ");
				linha = br.readLine();
				if (linha == "y") { //Não está funcionando fica em loop eterno
					break;
				}
			}
			bw.write(linha);
			bw.newLine();
			bw.flush(); //Serve para lancar imediatamente o que há guardado no BufferedWriter (?)
			linha = br.readLine();
		}
		br.close();
		bw.close();

		
	}

}
