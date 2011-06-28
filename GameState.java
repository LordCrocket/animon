import java.util.LinkedList;
import java.util.ArrayList;
class GameState {
	private static final GameState gameState = new GameState();	
	private LinkedList<Player> players;
	private int maxPlayers = 3, startingNumberOfAnimons =2;
	private Menu currentMenu;
	private boolean infoChanged;
	private Player currentWinner;
	private AniDex aniDex;
	private String latestEvent;

	public static GameState getInstance(){
		return gameState;
	}

	GameState(){
		aniDex = AniDex.getAniDex();
		players = new LinkedList<Player>();
				

		currentMenu = new Menu(MenuType.main);
		infoChanged = true;
	}

	public boolean infoChanged(){
		return infoChanged;
	}

	public void setInfoChanged(boolean newState){
		infoChanged = newState;
	}


	public void addPlayer(String name){
		if(getNumberOfPlayers()<maxPlayers){
			players.addLast(new Player(name));
		}
	}
	public void removeCurrentPlayer(){
		players.pop();
		if(players.size()==1)
			currentWinner = players.peek();
	}

	public int getNumberOfPlayers(){
		return players.size();
	}
	public int getStartingNumberOfAnimons(){
		return startingNumberOfAnimons;
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
		if(getNumberOfPlayers()==0)
			return null;
		else if(getNumberOfPlayers() > 1)
			return players.get(1); 
		return	players.get(0); 
	}

	public void changePlayer(){
		players.addLast(players.pop());
	}
	public Animon getCurrentAnimon(){
		Player currentPlayer = getCurrentPlayer();
		if(currentPlayer != null)
			return currentPlayer.getCurrentAnimon();
		else return null;
	}
	public Animon getDefendingAnimon(){
		return getNextPlayer().getCurrentAnimon();
	}
	public void removeDefendingAnimon(){
		getNextPlayer().removeCurrentAnimon();
	}
	public ArrayList<String> getAllAnimonTypeNames(){
		return aniDex.getAnimonNames();
	}

	public String getLatestEvent(){
		return latestEvent;
	}
	public void setLatestEvent(String latestEvent){
		this.latestEvent = latestEvent;
	}

	public Player getWinner(){
		return currentWinner;
	}
	public boolean gameWon(){
		if(currentWinner!=null)
			return true;
		return false;
	}

}
