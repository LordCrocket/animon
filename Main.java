import java.util.ArrayList;
class Main {
		
	public static void main(String []args){
		
		AniDex aniDex = AniDex.getAniDex();
		Window window = new Window();
		
		GameState gameState = GameState.getInstance();
		gameState.addPlayer("Rasmus");
		gameState.addPlayer("Marcus");
	//	gameState.addPlayer("Linda");

		
		Animon a1 = AnimonFactory.create("wolf");
		Animon a4 = AnimonFactory.create("wolf");
		Animon a2 = AnimonFactory.create("deer");
		Animon a3 = AnimonFactory.create("elephant");

	
		gameState.getCurrentPlayer().addAnimon(a1);
		gameState.getCurrentPlayer().addAnimon(a3);
		gameState.changePlayer();
		

		gameState.getCurrentPlayer().addAnimon(a2);
		gameState.getCurrentPlayer().addAnimon(a4);
		gameState.changePlayer();

		//gameState.getCurrentPlayer().addAnimon(a3);
		//gameState.changePlayer();
		


		a1.learnAttack(aniDex.getAttack("bite"));

		}

}
