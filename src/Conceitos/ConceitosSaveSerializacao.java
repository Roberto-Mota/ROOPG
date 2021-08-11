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
		 * criando uma persist�ncia nos estados dos objetos (?). Para tal � usado o
		 * sistema de serializa��o (transforma��o do objeto em um fluxo bin�rio).
		 *  Isso tamb�m pode ser �til em troca de informa��es em rede
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
		
		// essas classes n�o podem ser utilizadas em qualquer objeto, pois pode ocorrer o NotSerializableException
		// Para adotar a possibilidade, precisa adotar o contrato da interface Serializable (interface sem m�todos,
		// tamb�m chamda de interface de marca��o)
		// A serializa��o pode ser feita apenas na classe m�e sem problemas

	}
}
