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
				case KeyEvent.VK_LEFT:if(coloumns>1)gameState.setCurrentChoice(currentChoice-1);break;
				case KeyEvent.VK_RIGHT:if(coloumns>1)gameState.setCurrentChoice(currentChoice+1);break;
				case KeyEvent.VK_ENTER:enterClick(currentChoice, menuType);break;
				case KeyEvent.VK_ESCAPE:
					if(!(menuType == MenuType.menuBar || menuType ==MenuType.main )) 
						gameState.setCurrentMenu(new Menu(MenuType.menuBar));break;
				case KeyEvent.VK_SPACE:spaceClicked(menuType);
			}
			GUI.repaint();
			}

	public void enterClick(int currentChoice, MenuType menuType){
		Animon current = gameState.getCurrentAnimon();

		switch(menuType){
			case main:mainMenu(currentChoice);break;
			case newGame :newGame();break;
			case animonChoice :animonChoice();break;
			case menuBar:menuBar(currentChoice, current);break;
			case changeAnimon:changeAnimon(currentChoice);break;
			case attacks:attacksMenu(currentChoice,current);break;
		}
	}

	public void spaceClicked(MenuType type){
		if(type == MenuType.menuBar){
			boolean nothingDone = true;
			changeTurn(nothingDone);
		}	

	}

	public void mainMenu(int currentChoice){
		if(currentChoice == 0){
			gameState.setCurrentMenu(new Menu(MenuType.newGame)); 
			gameState.setInfoChanged(true);
		}

	}

	public void newGame(){
		if(GUI.namesFilled()){
			for(String name: GUI.getPlayerNames()){ 
				gameState.addPlayer(name);
			}
			
			gameState.setCurrentMenu(new Menu(gameState.getAllAnimonTypeNames(),MenuType.animonChoice)); 
			gameState.setInfoChanged(true);

		}
	}
	
	public void animonChoice(){
			String animon = gameState.getCurrentMenu().getChoice();
			gameState.getCurrentPlayer().addAnimon(AnimonFactory.create(animon));
			gameState.changePlayer();

			if(gameState.getCurrentPlayer().getNumberOfAnimons() == gameState.getStartingNumberOfAnimons()){
				gameState.setCurrentMenu(new Menu(MenuType.menuBar)); 
				gameState.setInfoChanged(true);
				gameState.setLatestEvent("Game started");
			}

	}
	public void menuBar(int currentChoice, Animon current){
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
		Player currentPlayer = gameState.getCurrentPlayer();
		currentPlayer.setCurrentAnimon(currentChoice); 
		gameState.setCurrentMenu(new Menu(MenuType.menuBar));
		gameState.setInfoChanged(true);

		gameState.setLatestEvent(currentPlayer.getName() + " changed Animon to :"+ gameState.getCurrentAnimon().getType().getName()); 

	}
	public void attacksMenu(int currentChoice, Animon current){
			Result result = Combat.attack(current, gameState.getDefendingAnimon(),currentChoice);
					
			String currentPlayerName = gameState.getCurrentPlayer().getName();
				
			if(result.getOutCome() == Result.OK){
				gameState.setLatestEvent(buildAttackMessage(currentPlayerName,result));
				if(gameState.getDefendingAnimon().getHp()==0){
					gameState.setLatestEvent(gameState.getLatestEvent()+", it died");				gameState.removeDefendingAnimon();
				}
				boolean nothingDone = false;
				changeTurn(nothingDone);
			}
			else if(result.getOutCome() == Result.NOT_ENOUGH_MANA){
				gameState.setLatestEvent(currentPlayerName+ "'s " + current.getType().getName() + " doesn't have enough mana.");	
				
			}

			gameState.setCurrentMenu(new Menu(MenuType.menuBar));
			gameState.setInfoChanged(true);
	}

	public void changeTurn(boolean nothingDone){

			gameState.getNextPlayer().updateAnimons();
			gameState.changePlayer();

			while(gameState.getCurrentAnimon()==null){
					gameState.setLatestEvent(gameState.getCurrentPlayer().getName()+ " lost!");
					gameState.removeCurrentPlayer();

			}
				if(gameState.gameWon())
					gameState.setLatestEvent(gameState.getWinner().getName()+" won!");
			else{
				if(nothingDone)
					gameState.setLatestEvent(gameState.getCurrentPlayer().getName()+"'s turn.");
			}

	}
	public String buildAttackMessage(String currentPlayerName,Result result){
		String nextPlayerName = gameState.getNextPlayer().getName();

		String tmp="";
		tmp+= currentPlayerName+"'s ";
		tmp+= gameState.getCurrentAnimon().getType().getName()+ " dealt ";
		tmp+=result.getDamageDone() + " damage to ";
		tmp+=nextPlayerName+"'s ";
		tmp+=gameState.getDefendingAnimon().getType().getName(); 
		return tmp;

	}	
										

}
