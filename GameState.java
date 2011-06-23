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

	public void changePlayer(){
		currentPlayer = (currentPlayer+1)%maxPlayers;
	}
	public String getCurrentAnimonName(){
		return players[currentPlayer].getAnimon(0).getType().getName();
	}

	public int getCurrentAnimonHp(){
		return players[currentPlayer].getAnimon(0).getHp();
	}
	public int getCurrentAnimonMana(){
		return players[currentPlayer].getAnimon(0).getMana();
	}
	public int getCurrentAnimonMaxHp(){
		return players[currentPlayer].getAnimon(0).getType().getHp();
	}
	public int getCurrentAnimonMaxMana(){
		return players[currentPlayer].getAnimon(0).getType().getMana();
	}


	

}
