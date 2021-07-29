package gameStructure;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CombatSystem {
	
	Scanner in = new Scanner(System.in);
	Random rand = new Random(); // Utilizar para randomizacaooo de coisas no jogo
	


	// Variaveis dos inimigos
	ArrayList monsters = new ArrayList();
	String[] enemies = { "Spider", "Skeleton", "Zombie", "Slime" }; // Cria-se, de forma literal, uma array de strings
	int maxEnemyHealth = 95;
	int enemyAttackDamage = 15;

	// Geracao randomica entre os inimigos possiveis


	boolean combat = true;

	public void BeastCombat(Player player, boolean combat) {
		while (combat == true) {
			//Monster Spawn
			String enemy = enemies[rand.nextInt(enemies.length)]; // Pega o nome do inimigo
			int enemyHealth = rand.nextInt(maxEnemyHealth); // The paramater is the max value that this random int can be (0 to
			// numero dado)
			
			//Inventario do player
			
			double healthPotionHealAmount = player.getHealthPotionHealAmount();
			int numHealthPotions = player.getNumHealthPotions();
			int healthPotionDropChance = player.getHealthPotionDropChance();

			while (enemyHealth > 0) {
				
				double health = player.getVitals().getHealth();

				if (health <= 0) { // Morrer
					System.out.println("\tGAME OVER!");
					break; // Esse break quebra o loop running
				}
				System.out.println("\t# " + enemy + " has appeared! #\n");
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1: Attack");
				System.out.println("\t2: Drink health potion");
				System.out.println("\t3: Run!");
				String combatChoice = null;

				combatChoice = in.nextLine(); // Estou com dificuldade nessa parte, precisarei estudar mais objects,
												// scanners e stream

				if (combatChoice == null) {
					System.out.println("entrou aqui");
				}

				else if (combatChoice.equals("1")) { // Atacar o inimgo
					int damageDealt = rand.nextInt(player.getAttackDamage());
					int damageTaken = rand.nextInt(enemyAttackDamage);

					enemyHealth -= damageDealt;
					player.getVitals().setHealth(health -= damageTaken);

					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You receive " + damageTaken + " damage from the " + enemy + ".");

					if (player.getVitals().getHealth() <= 0) {
						System.out.println("\t You have taken too much damage and died.");
						break;
					}

				} else if (combatChoice.equals("2")) { // Escolher bebe po��o
					if (player.getNumHealthPotions() > 0) {
						health += healthPotionHealAmount;
						player.setNumHealthPotions(numHealthPotions--);
						System.out.println("You drink a health potion and restores " + healthPotionHealAmount + "."
								+ "\n\t You have " + health + " HP now." + "You now have " + numHealthPotions
								+ " potions left.");
					} else {
						System.out.println("You have no potions left.");
					}

				}

				else if (combatChoice.equals("3")) { // Tentar correr
					int runTry = rand.nextInt(player.getAgility());
					if (runTry > 2) { // Hard code que pode ser alterado
						System.out.println("\tYou ran away from the enemy.");
						break; // Quebra para o loop anterior, fugindo assim do combate e voltando para a classe menutest
					} else {
						System.out.println("\tYou tried to run away, but you failed.");
					}
				}

				else { // Digito inv�lido, por ser um while loop, vai voltar pro inicio novamente
					System.out.println("Invalid input, try again.");
				}

			}

			System.out.println("--------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + player.getVitals().getHealth() + " HP left. # ");
			if (rand.nextInt(100) >= healthPotionDropChance) {
				player.setNumHealthPotions(numHealthPotions++);
				System.out.println("The enemy dropped a health potion.");
				System.out.println("Now you have " + player.getNumHealthPotions() + " potion(s).");
				combat = false; }
				else {
					combat = false;
				}

			

		}

	}
}
