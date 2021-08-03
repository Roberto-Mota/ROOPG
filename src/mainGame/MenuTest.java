package mainGame;

import java.util.Random;
import java.util.Scanner;

import gameStructure.CombatSystem;
import gameStructure.Player;

public class MenuTest {

	public static void main(String[] args) {

		// Objetos do sistema
		Scanner in = new Scanner(System.in);
		Random rand = new Random(); // Utilizar para randomizacao de coisas no jogo
		
		CombatSystem cs = new CombatSystem(); Não pode mais instanciar o CombatSystem
		boolean running = true;
		boolean menuChoices = true;

		System.out.println("Welcome to ROOPG");

		// GAME: "Label" do loop while
		while (running) {
			System.out.println("--------------------------------------");

			// Character creation
			System.out.println("Whats your name?");
			String input = in.nextLine(); // Retorna qualquer coisa que eu escrever no console (pode abrir aqui pra
											// possibilidades de GUI)
			String nomePersonagem = input;

			System.out.println("Choose your class");
			String escolhaClasse = in.nextLine();
			// Aqui abre espaÃ§o para a escolha da classe e atribuiÃ§Ã£o no respectivo
			// objeto,
			// podendo implementar um switch ou um ENUMS

			Player player = new Player(nomePersonagem, false);

			player.setNome(nomePersonagem);

			MENU: while (menuChoices) {
				System.out.println("\tYou are on your own.");
				System.out.println("\t1: Hunt down monsters");
				System.out.println("\t2: ");
				System.out.println("\t3: ");
				System.out.println("\t4: ");
				System.out.println("\t5: Try to sleep.");
				Scanner menuIn = new Scanner(System.in);
				int menuChoicesOption = menuIn.nextInt();
				while (menuChoicesOption > 5) { // "Nï¿½o ï¿½ igual a"
					System.out.println("Invalid command");
					input = in.nextLine();
				}
				switch (menuChoicesOption) {
				case 1: {
					System.out.println("You go on a search for enemies.");
					cs.BeastCombat(player, true);

					break;
				}

				case 2: // Tentar dormir, com leve risco de spawnar outro mob

				{

					System.out.println("How many hours do you want to sleep?");
					int hoursSleep = in.nextInt();
					System.out.println("\tYou lay down to sleep.");
					if (rand.nextInt(player.getLuck()) <= 2) {
						System.out
								.println("You wake up in the middle of your sleep with a loud noise, it's a monster!");
						cs.BeastCombat(player, true);

					} else {
						player.sleep(hoursSleep);
					}
					break;
				}

				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Não rolou");
				}

			}

			// COMBAT:

			System.out.println("--------------------------------------");
			System.out.println("What would you like to do?");
			System.out.println("\t1: Continue fighting.");
			System.out.println("\t2: Exit the dungeon.");

			int dungeonChoicesOption = in.nextInt();

			switch (dungeonChoicesOption) {

			}

			while (0 >= dungeonChoicesOption || dungeonChoicesOption <= 3) {
				System.out.println("Invalid command");
				input = in.nextLine();
			}

			if (input.equals("1")) {
				System.out.println("You continue with your adventure!");
			} else if (input.equals("2")) {
				System.out.println("You left the dungeon, succesful from your adventures!");
				break;
			}

		}

		System.out.println("\t#----------------#");
		System.out.println("\tThanks for playing!");
		System.out.println("\t#----------------#");

	}
}

/**
 * Como deletar um objeto: Example 1:
 * 
 * Object a = new Object(); a = null; // after this, if there is no reference to
 * the object, // it will be deleted by the garbage collector Example 2:
 * 
 * if (something) { Object o = new Object(); } // as you leave the block, the
 * reference is deleted. // Later on, the garbage collector will delete the
 * object itself.
 * 
 * ------------------------------------------------------------------------------
 * System.out.println("5)details of the student personal info");
 * System.out.println("6)Exit"); selection = sc.nextInt(); switch (selection) {
 * case 1 : System.out.println("Enter studentName "); sc = new
 * Scanner(System.in); String studentName= sc.nextLine(); Student studentInfo =
 * student.createStudent(studentName); System.out.println("Do you want to
 * continue? Type Yes / No"); Scanner sc1 = new Scanner(System.in);
 * 
 * case 2 : break; case 3 : break; case 4 : break; case 5 : break; case 6 :
 * break;
 */
