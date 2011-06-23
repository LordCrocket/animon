import java.util.ArrayList;
class Main {
	
	public static void main(String []args){

		Attack bite = new Attack(20,"Bite",10);

		ArrayList<Attack> wolfAttacks = new ArrayList<Attack>();	

		wolfAttacks.add(bite);

		AnimonType wolf = new AnimonType("Wolf",100,50,wolfAttacks);
		AnimonType deer = new AnimonType("Deer",150,50,null);




		Animon a1 = new Animon(wolf);
		Animon a2 = new Animon(deer);
		Animon a3 = new Animon(wolf);

		Combat.attack(a1,a2,0);	
		
		System.out.println(a1 + "\n");
		System.out.println(a2 +"\n");
		System.out.println(a3 +"\n");

		/*
		Menu menu = new Menu();	
		System.out.println(menu);
		menu.choose();
		System.out.println(menu.getChoice());
		*/
	}

}
