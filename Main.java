import java.util.ArrayList;
import java.util.Scanner;
class Main {
	
	public static void main(String []args){
		
		Scanner sc = new Scanner(System.in);
		AniDex aniDex = AniDex.getAniDex();
		AniGUI gui = new AniGUI(GameState.getInstance());


		AnimonType wolf = aniDex.getAnimon("wolf");
		AnimonType deer = aniDex.getAnimon("deer");



		Animon a1 = new Animon(wolf);
		Animon a2 = new Animon(deer);
		Animon a3 = new Animon(wolf);

		

		Player p1 = new Player("Rasmus");
		Player p2 = new Player("Marcus");

		p1.addAnimon(a1);
		a1.learnAttack(aniDex.getAttack("bite"));
		p2.addAnimon(a2);

		
		
		Menu mainMenu = new Menu();
		Menu combatMenu;
		Player currentPlayer = p1;
		Player otherPlayer = p2;
		for(;;){	
			
			System.out.println(p1 + "\n");
			System.out.println(p2 + "\n");
			
			System.out.println(currentPlayer.getName()+ "'s turn!");	
			System.out.println(mainMenu);

			int choice = Integer.parseInt(sc.nextLine())-1;
			mainMenu.choose(choice);
			if(mainMenu.getChoiceNumber() == Menu.ATTACK){
				Animon current= currentPlayer.getAnimon(0);
				combatMenu = new Menu(current.getAttackNames()); 	
				System.out.println(combatMenu);
				choice = Integer.parseInt(sc.nextLine())-1;
				combatMenu.choose(choice);
				
				int result = Combat.attack(current,otherPlayer.getAnimon(0),choice);	
				if(result == Combat.NOT_ENOUGH_MANA)
					System.out.println("Not enough mana.");
			}
			System.out.println("\nCurrent standing");
			System.out.println("==================\n");
			Player temp = currentPlayer;
			currentPlayer = otherPlayer;
			otherPlayer = temp;
		}
	}

}
