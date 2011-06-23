class GameState {
	private static final GameState gameState = new GameState();	
	private Player[] players;
	private int currentPlayer, maxPlayers = 2, numberOfPlayers = 0;
	private Menu currentMenu;

	public static GameState getInstance(){
		return gameState;
	}

	GameState(){
		AniDex aniDex = AniDex.getAniDex();
		players = new Player[maxPlayers];
		currentMenu = new Menu();

	}

	public void addPlayer(String name){
		if(numberOfPlayers<maxPlayers)
			players[numberOfPlayers++] = new Player(name);
	}

	public Player getCurrentPlayer(){
		return players[currentPlayer]; 
	}

	

}
