import java.awt.event.*;
class Controller {
	private GameState gameState;
	private AniGUI GUI;
	Controller(AniGUI GUI){
		gameState = GameState.getInstance();
		this.GUI = GUI;
	}

	public void buttonPushed(int key){
			int currentChoice = gameState.getCurrentChoice();
			int coloumns = gameState.getCurrentMenu().getColoumns();
			MenuType menuType = gameState.getCurrentMenu().getType();
			switch(key){
				case KeyEvent.VK_UP:gameState.setCurrentChoice(currentChoice-coloumns);break;
				case KeyEvent.VK_DOWN:gameState.setCurrentChoice(currentChoice+coloumns);break;
				case KeyEvent.VK_LEFT:gameState.setCurrentChoice(currentChoice-1);break;
				case KeyEvent.VK_RIGHT:gameState.setCurrentChoice(currentChoice+1);break;
				case KeyEvent.VK_ENTER:enterClick(currentChoice, menuType);break;
				case KeyEvent.VK_ESCAPE:
					if(!(menuType == MenuType.main)) 
						gameState.setCurrentMenu(new Menu());break;
			}
			GUI.repaint();
			}

	public void enterClick(int currentChoice, MenuType menuType){
		Animon current = gameState.getCurrentAnimon();

		switch(menuType){
			case main:mainMenu(currentChoice, current);break;
			case changeAnimon:changeAnimon(currentChoice);break;
			case attacks:attacksMenu(currentChoice,current);break;
		}
	}
	public void mainMenu(int currentChoice, Animon current){
		if(currentChoice==Menu.ATTACK){
			gameState.setCurrentMenu(new Menu(current.getAttackNames(),MenuType.attacks)); 
			gameState.setInfoChanged(true);
		}
		else if(currentChoice==Menu.CHANGE_ANIMON){
			gameState.setCurrentMenu(new Menu(gameState.getCurrentPlayer().listAnimons(),MenuType.changeAnimon)); 
			gameState.setInfoChanged(true);
		}
	}

	public void changeAnimon(int currentChoice){
		gameState.getCurrentPlayer().setCurrentAnimon(currentChoice); 
		gameState.setCurrentMenu(new Menu());
		gameState.setInfoChanged(true);

	}
	public void attacksMenu(int currentChoice, Animon current){
			Combat.attack(current, gameState.getDefendingAnimon(),currentChoice);
			gameState.changePlayer();
			gameState.setCurrentMenu(new Menu());
			gameState.setInfoChanged(true);


	}
										

}
