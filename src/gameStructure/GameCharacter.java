package gameStructure;

import java.util.Random;

public class GameCharacter { // caso eu precisa fazer um espï¿½cie de heranï¿½a mï¿½ltipla com alguma classe,
									// precisarei usar interfaces

	// Value Objects = classes que se limitam a ter atributos privados com os
	// setters e getters.
	// Parsing é passar de um tipo para o outro (como String para int, etc.)

	private String nome;
	protected double gold;
	private double xp;
	private int level;
	
	private Integer attackDamage = Integer.valueOf((level + 10) * 2); //autoboxing (jogar para uma variavel primitva sera o unboxing
	private int numHealthPotions = 5;
	private int healthPotionHealAmount = 30;
	private int healthPotionDropChance = 50; // Porcentagem
	private int agility = 5;
	private Integer luck = Integer.valueOf(2);
	

	private boolean NPC = false;
	public static int total;
	Vitals vitals = new Vitals();
	Special special = new Special();

	public GameCharacter(String nome, boolean NPC) { // creating Player
		this.nome = nome;
		this.NPC = NPC;
		this.level = 5; //Deixar no level 5 apenas para testes
		this.xp = 0;
		this.gold = 0;
		GameCharacter.total++;
	}

	public GameCharacter(String nome, Player player, boolean NPC) { //spawning NPC
		Random rand = new Random();
		this.NPC = NPC;
		
		this.setNome(nome);
		
		// TODO: setNome pegue uma lista String de possíveis nomes para cada tipo de npc em suas respectivas classes
		//this.setNome(Object.Namelist[rand.nextInt(list.Length)]);
		
		this.setLevel(rand.nextInt(player.getLevel()- 1)+1);
		this.setAgility(rand.nextInt(8));	//(rand.nextInt(this.getLevel()- 1)+1); <- Versão oficial em teste sem hardcode
		
	}

	public boolean attack(double dano, GameCharacter enemy) {
		if (NPC) {

		}
		if (this.vitals.stamina >= 15) {
			this.vitals.stamina -= 15;
			enemy.vitals.health -= dano;
			System.out.println(this.nome + " attacked " + enemy.nome + " and did " + dano + " of damage.");
			return true;
		} else {
			System.out.println("Not enough stamina");
			return false;
		}
	}
	
	@Override
		public String toString() { //O Sysout direto já imprime esse caminho quando a classe está no parâmetro.
			return this.nome; 
		}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public double getXp() {
		return xp;
	}

	public void setXp(double xp) {
		this.xp = xp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Vitals getVitals() {
		return vitals;
	}

	public void setVitals(Vitals vitals) {
		this.vitals = vitals;
	}
	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getNumHealthPotions() {
		return numHealthPotions;
	}

	public void setNumHealthPotions(int numHealthPotions) {
		this.numHealthPotions = numHealthPotions;
	}

	public int getHealthPotionHealAmount() {
		return healthPotionHealAmount;
	}

	public void setHealthPotionHealAmount(int healthPotionHealAmount) {
		this.healthPotionHealAmount = healthPotionHealAmount;
	}

	public int getHealthPotionDropChance() {
		return healthPotionDropChance;
	}

	public void setHealthPotionDropChance(int healthPotionDropChance) {
		this.healthPotionDropChance = healthPotionDropChance;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public boolean isNPC() {
		return NPC;
	}

	public void setNPC(boolean nPC) {
		NPC = nPC;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		GameCharacter.total = total;
	}

	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}


}
