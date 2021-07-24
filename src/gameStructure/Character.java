package gameStructure;

public abstract class Character { //caso eu precisa fazer um esp�cie de heran�a m�ltipla com alguma classe, precisarei usar interfaces
	
	//Value Objects = classes que se limitam a ter atributos privados com os setters e getters.
	
	private String nome;
	protected double gold;
	private double xp;
	private int level;

	private boolean NPC = false;
	public static int total;
	Vitals vitals = new Vitals();
	Special special = new Special();
	
	public Character(String nome, boolean NPC) {
		this.nome = nome;
		this.NPC = NPC;
		this.level = 1;
		this.xp = 0;
		this.gold = 0;
		Character.total++;
	}

	public Character(String nome, Player player, boolean NPC) {
		this.setLevel(player.getLevel() - 1);
	}
	
	public boolean attack(double dano, Character enemy) {	
		if(NPC) {
			
		}
		if(this.vitals.stamina >= 15) {
			this.vitals.stamina -= 15;
			enemy.vitals.health -= dano;
			System.out.println(this.nome + " attacked " + enemy.nome + " and did " + dano + " of damage.");
			return true;
		} else {
			System.out.println("Not enough stamina");
			return false;
		}
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

}
