class GameState {
	private static final GameState gameState = new GameState();	
	private Player[] players;
	private int currentPlayer, maxPlayers = 3, numberOfPlayers = 0;
	private Menu currentMenu;
	private boolean infoChanged;

	public static GameState getInstance(){
		return gameState;
	}

	GameState(){
		AniDex aniDex = AniDex.getAniDex();
		players = new Player[maxPlayers];
		currentMenu = new Menu();
		infoChanged = true;
	}

	public boolean infoChanged(){
		return infoChanged;
	}

	public void setInfoChanged(boolean newState){
		infoChanged = newState;
	}


	public void addPlayer(String name){
		if(numberOfPlayers<maxPlayers)
			players[numberOfPlayers++] = new Player(name);
	}

	public Menu getCurrentMenu(){
		return currentMenu;
	}
	public void setCurrentMenu(Menu newMenu){
		currentMenu = newMenu;
	}

	public int getCurrentChoice(){
		return currentMenu.getChoiceNumber();
	}

	public void setCurrentChoice(int choice){
		currentMenu.choose(choice);	
	}

	public Player getCurrentPlayer(){
		return players[currentPlayer]; 
	}
	public Player getNextPlayer(){
		return players[(currentPlayer+1)%numberOfPlayers]; 
	}

	public void changePlayer(){
		currentPlayer = (currentPlayer+1)%numberOfPlayers;
	}
	public Animon getCurrentAnimon(){
		return players[currentPlayer].getCurrentAnimon();
	}
	public Animon getDefendingAnimon(){
		return getNextPlayer().getCurrentAnimon();
	}

}
