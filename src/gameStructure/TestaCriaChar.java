package gameStructure;

public class TestaCriaChar {

	public static void main(String[] args) {
		Player Kormok = new Player("Kormok", false);
		Beast Spider = new Beast ("Spider",Kormok, true);
		
		Kormok.getVitals().getStamina();
		
		Kormok.attack(15, Spider);
		Spider.attack(10, Kormok);
		
		Kormok.sleep(2);
		
		Kormok.getVitals().getStamina();
		
		System.out.println(Kormok.getVitals().getHealth());
		
		
		

	}

}
