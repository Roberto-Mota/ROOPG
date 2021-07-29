package Conceitos;
import java.time.*;
import java.util.Random;
import java.util.Scanner;

import gameStructure.Player;

public class Conceitos {
	
	//	Aplicar conceitos de Exception
	//	Fazer os comentários de todo o programa
	// Talvez o conceito de atributos de rpg (força, percepção etc. seja conveniente em uma interface)
	
	/**
	 * @author (usado na classe ou interface)
	 * @version (usado na classe ou interface)
	 * @param (usado no método e construtor)
	 * @return (usado apenas no método)
	 * @exception ou @throws (no método ou construtor)
	 * @see
	 * @since
	 * @serial
	 * @deprecated
	 * @param args
	 * @Override (considerada uma configuração, nesse caso interpretado pelo compilador)
	 */

    public static void main(String[] args) {

		// Objetos do sistema
    	//Instant relogio = new Instant(1234564565555555456, 5);
		Scanner in = new Scanner(System.in);
		Random rand = new Random(); // Utilizar para randomizaÃ§Ã£oo de coisas no jogo

		// VariÃ¡veis do Jogo
		String[] enemies = { "Spider", "Skeleton", "Zombie", "Slime" }; // Ver esse conceito
		int maxEnemyHealth = 95;
		int enemyAttackDamage = 15;

		// VariÃ¡veis do Personagem suscetÃ­ves a variaÃ§Ã£o
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


			MENU: while (menuChoices) {
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

					}
					}

				

				else if (menuChoicesOption == 2) {

					System.out.println("You go on a search for enemies.");
					combat = true;
				}
         }

				// COMBAT:
				while (combat == true) {

					// GeraÃ§Ã£o randomica entre os inimigos possÃ­veis
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


						String combatChoice = in.nextLine();
						
						if (combatChoice == null) {
                            System.out.println("teste");
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

						} else if (combatChoice.equals("2")) { // Escolher bebe poï¿½ï¿½o
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

						else if (combatChoice.equals("3")) { 
							int runTry = rand.nextInt(agility);
							if (runTry > 2) { 
								System.out.println("\tYou ran away from the enemy.");
								continue; 
							} else {
								System.out.println("\tYou tried to run away, but you failed.");
							}
						}

						else { 
							System.out.println("Invalid input, try again.");
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
                    }}}}}
