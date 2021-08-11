package Conceitos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ConceitosSaveSerializacao {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		/**
		 * java.ioObsjectOutputStream java.io.ObjectInputStream
		 * 
		 * Essas duas classes conseguem transformar objetos em um stream de bit e bytes,
		 * criando uma persistência nos estados dos objetos (?). Para tal é usado o
		 * sistema de serialização (transformação do objeto em um fluxo binário).
		 *  Isso também pode ser útil em troca de informações em rede
		 * 
		 */

//		String nome = "Paulo";
//
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.bin"));
//		oos.writeObject(nome);
//		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream (new FileInputStream("save.bin"));
		String nome = (String) ois.readObject();
		
		System.out.println(nome);
		
		// essas classes não podem ser utilizadas em qualquer objeto, pois pode ocorrer o NotSerializableException
		// Para adotar a possibilidade, precisa adotar o contrato da interface Serializable (interface sem métodos,
		// também chamda de interface de marcação)
		// A serialização pode ser feita apenas na classe mãe sem problemas

	}
}
