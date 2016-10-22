import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
class AniGUI extends JPanel {
	JPanel bottomBar;
	NewGameGUI newGame;
	Window mainWindow;
	GraphicalComponent animonInfo,defendingInfo,menuBar,mainMenu,animonChoice;
	JLabel latestEvent;
	GameState gameState = GameState.getInstance();


	AniGUI(Window mainWindow){	
		this.mainWindow = mainWindow;
		setLayout(null);
		setSize(800,500);
		buildMainGUI();
	}

	public void buildMainGUI(){
		int xMax = mainWindow.getXSize();	
		int yMax = mainWindow.getYSize();	
		animonInfo = new AnimonInfoGUI(0,yMax-150,true);
		defendingInfo = new AnimonInfoGUI(xMax-350,50,false);

		menuBar = new MenuBarGUI(xMax-400,yMax-150,400,150);
		mainMenu = new MainMenuGUI(200,200);
		newGame = new NewGameGUI(200,100,mainWindow);
		animonChoice = new MenuBarGUI(20,20, xMax,yMax);
		
		latestEvent = new JLabel();
		

		add(latestEvent);
		add(defendingInfo);
		add(animonInfo);	
		add(menuBar);	

	}

	public boolean namesFilled(){
		return newGame.isFilled();
	}

	public ArrayList<String> getPlayerNames(){
		return newGame.getNames(); 
	} 

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		remove(mainMenu);
		remove(newGame);
		remove(animonChoice);
		mainWindow.requestFocus();
		MenuType currentMenu = gameState.getCurrentMenu().getType();
		switch(currentMenu){
			case main: add(mainMenu);mainMenu.draw();break; 
			case newGame: add(newGame);newGame.draw();break; 
			case animonChoice: add(animonChoice);animonChoice.draw();break; 

			default :
					menuBar.draw();
					latestEvent.setText(gameState.getLatestEvent());
					latestEvent.setBounds(mainWindow.getXSize()-700,mainWindow.getYSize()-200,500,50);	
					if(gameState.infoChanged()){
							animonInfo.draw();
						if(!gameState.gameWon())
							defendingInfo.draw();
						gameState.setInfoChanged(false);
					}
					break;
		}
	}
	
}
