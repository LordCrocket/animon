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
			int coloumns = MenuBarGUI.COLOUMNS;
			String menuName = gameState.getCurrentMenu().getName();
			switch(key){
				case KeyEvent.VK_UP:gameState.setCurrentChoice(currentChoice-coloumns);break;
				case KeyEvent.VK_DOWN:gameState.setCurrentChoice(currentChoice+coloumns);break;
				case KeyEvent.VK_LEFT:gameState.setCurrentChoice(currentChoice-1);break;
				case KeyEvent.VK_RIGHT:gameState.setCurrentChoice(currentChoice+1);break;
				case KeyEvent.VK_ENTER:
					Animon current = gameState.getCurrentAnimon();
					if(currentChoice==Menu.ATTACK && menuName.equals("main")){
						gameState.setCurrentMenu(new Menu(current.getAttackNames(),"attacks")); 
					}
					else if(menuName.equals("attacks")){
						Combat.attack(current, gameState.getDefendingAnimon(),currentChoice);
						gameState.changePlayer();
						gameState.setCurrentMenu(new Menu());
					}
				break;
				case KeyEvent.VK_ESCAPE:
					if(!menuName.equals("main")) 
						gameState.setCurrentMenu(new Menu());break;
			}
			GUI.repaint();
			}
	

}
