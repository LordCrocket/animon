import java.util.ArrayList;
import java.util.Scanner;
class Main {
		
	public static void main(String []args){
		
		//Scanner sc = new Scanner(System.in);
		AniDex aniDex = AniDex.getAniDex();
		Window window = new Window();
		
		GameState gameState = GameState.getInstance();
		gameState.addPlayer("Rasmus");
		gameState.addPlayer("Marcus");
		gameState.addPlayer("Linda");

		AnimonType wolf = aniDex.getAnimon("wolf");
		AnimonType deer = aniDex.getAnimon("deer");
		AnimonType elephant = aniDex.getAnimon("elephant");



		Animon a1 = new Animon(wolf);
		Animon a2 = new Animon(deer);
		Animon a3 = new Animon(elephant);
	
		gameState.getCurrentPlayer().addAnimon(a1);
		gameState.changePlayer();

		gameState.getCurrentPlayer().addAnimon(a2);
		gameState.changePlayer();

		gameState.getCurrentPlayer().addAnimon(a3);
		gameState.changePlayer();
		


		a1.learnAttack(aniDex.getAttack("bite"));

		/*	
		
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
		*/
	}

}
