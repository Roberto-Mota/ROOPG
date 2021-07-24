package mainGame;

import java.util.Random;
import java.util.Scanner;

import gameStructure.Player;

public class MenuTest {

	public static void main(String[] args) {

		// Objetos do sistema
		Scanner in = new Scanner(System.in);
		Random rand = new Random(); // Utilizar para randomizaçãoo de coisas no jogo

		// Variáveis do Jogo
		String[] enemies = { "Spider", "Skeleton", "Zombie", "Slime" }; // Ver esse conceito
		int maxEnemyHealth = 95;
		int enemyAttackDamage = 15;

		// Variáveis do Personagem suscetíves a variação
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 5;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // Porcentagem
		int agility = 5;
		int luck = 2;

		boolean running = true;
		boolean menuChoices = true;
		boolean combat = true;

		System.out.println("Welcome to ROOPG");

		// GAME: "Label" do loop while
		while (running) {
			System.out.println("--------------------------------------");

			// System.out.println("Whats your name?");
			// String input = in.nextLine(); // Retorna qualquer coisa que eu escrever no console (pode abrir aqui pra
			// 								// possibilidades de GUI)
			// String nomePersonagem = input;

			// System.out.println("Choose your class");
			// String escolhaClasse = in.nextLine();
			// // Aqui abre espaço para a escolha da classe e atribuição no respectivo objeto,
			// // podendo implementar um switch ou um ENUMS

			// Player player = new Player(nomePersonagem, false);

			// player.setNome(nomePersonagem);

			MENU: while (menuChoices) {
				System.out.println("\tYou are on your own.");
				System.out.println("\t1: Hunt down monsters");
				System.out.println("\t2: ");
				System.out.println("\t3: ");
				System.out.println("\t4: ");
				System.out.println("\t5: Try to sleep.");
				int menuChoicesOption = in.nextInt();

				if (menuChoicesOption == 5) { // Tentar dormir, com leve risco de spawnar outro mob
					System.out.println("How many hours do you want to sleep?");
					int hoursSleep = in.nextInt();
					System.out.println("\tYou lay down to sleep.");
					if (rand.nextInt(luck) <= 2) {
						combat = true;
						;
						System.out
								.println("You wake up in the middle of your sleep with a loud noise, it's a monster!");

					} else {
						//player.sleep(hoursSleep);
					}

				}

				else if (menuChoicesOption == 1) {

					System.out.println("You go on a search for enemies.");
					combat = true;
				}

				// COMBAT:
				while (combat == true) {

					// Geração randomica entre os inimigos possíveis
					int enemyHealth = rand.nextInt(maxEnemyHealth); // The paramater is the max value that this random int can be (0 to numero dado)
					String enemy = enemies[rand.nextInt(enemies.length)]; // Pega o nome do inimigo


					while (enemyHealth > 0) {

						System.out.println("\t# " + enemy + " has appeared! #\n");
						System.out.println("\tYour HP: " + health);
						System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
						System.out.println("\n\tWhat would you like to do?");
						System.out.println("\t1: Attack");
						System.out.println("\t2: Drink health potion");
						System.out.println("\t3: Run!");



						String combatChoice = in.nextLine(); //Estou com dificuldade nessa parte, precisarei estudar mais objects, scanners e stream
						
						if (combatChoice == null) {
						}

						else if (combatChoice.equals("1")) { // Atacar o inimgo
							int damageDealt = rand.nextInt(attackDamage);
							int damageTaken = rand.nextInt(enemyAttackDamage);

							enemyHealth -= damageDealt;
							health -= damageTaken;

							System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
							System.out.println("\t> You receive " + damageTaken + " damage from the " + enemy + ".");

							if (health <= 0) {
								System.out.println("\t You have taken too much damage and died.");
								break;
							}

						} else if (combatChoice.equals("2")) { // Escolher bebe po��o
							if (numHealthPotions > 0) {
								health += healthPotionHealAmount;
								numHealthPotions--;
								System.out.println("You drink a health potion and restores " + healthPotionHealAmount
										+ "." + "\n\t You have " + health + " HP now." + "You now have "
										+ numHealthPotions + " potions left.");
							} else {
								System.out.println("You have no potions left.");
							}

						}

						else if (combatChoice.equals("3")) { // Tentar correr
							int runTry = rand.nextInt(agility);
							if (runTry > 2) { // Hard code que pode ser alterado
								System.out.println("\tYou ran away from the enemy.");
								continue MENU; // O continue move pra próxima itera��o do loop, como n�s estamos em um
												// loop
												// aninhado, ao usarmos o label, voltamos pro desejado
							} else {
								System.out.println("\tYou tried to run away, but you failed.");
							}
						}

						else { // Digito inv�lido, por ser um while loop, vai voltar pro inicio novamente
							System.out.println("Invalid input, try again.");
						}
					}

					if (health <= 0) { // Morrer
						System.out.println("\tGAME OVER!");
						break; // Esse break quebra o loop running
					}

					System.out.println("--------------------------------------");
					System.out.println(" # " + enemy + " was defeated! # ");
					System.out.println(" # You have " + health + " HP left. # ");
					if (rand.nextInt(100) >= healthPotionDropChance) {
						numHealthPotions++;
						System.out.println("The enemy dropped a health potion.");
						System.out.println("Now you have " + numHealthPotions + " potion(s).");

					}

				}
				System.out.println("--------------------------------------");
				System.out.println("What would you like to do?");
				System.out.println("\t1: Continue fighting.");
				System.out.println("\t2: Exit the dungeon.");

				String input = in.nextLine();

				while (!input.equals("1") && !input.equals("2")) { // "N�o � igual a"
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
 */
