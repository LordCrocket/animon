import java.util.LinkedList;
class GameState {
	private static final GameState gameState = new GameState();	
	private LinkedList<Player> players;
	private int maxPlayers = 3, numberOfPlayers = 0;
	private Menu currentMenu;
	private boolean infoChanged;
	private Player currentWinner;

	public static GameState getInstance(){
		return gameState;
	}

	GameState(){
		AniDex aniDex = AniDex.getAniDex();
		players = new LinkedList<Player>();
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
		if(numberOfPlayers<maxPlayers){
			++numberOfPlayers;
			players.addLast(new Player(name));
		}
	}
	public void removeCurrentPlayer(){
		players.pop();
		if(players.size()==1)
			currentWinner = players.peek();
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
		return players.peek(); 
	}
	public Player getNextPlayer(){
		if(numberOfPlayers==0)
			return null;
		else if(numberOfPlayers > 1)
			return players.get(1); 
		return	players.get(0); 
	}

	public void changePlayer(){
		players.addLast(players.pop());
	}
	public Animon getCurrentAnimon(){
		return getCurrentPlayer().getCurrentAnimon();
	}
	public Animon getDefendingAnimon(){
		return getNextPlayer().getCurrentAnimon();
	}

}
