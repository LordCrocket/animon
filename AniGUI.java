import java.awt.*;
import javax.swing.*;
class AniGUI extends JPanel {
	JPanel bottomBar;
	GraphicalComponent animonInfo,defendingInfo,menuBar;
	GameState gameState = GameState.getInstance();


	AniGUI(){	
		setLayout(null);
		setSize(800,500);
		buildMainGUI();
	}

	public void buildMainGUI(){
		//bottomBar = new JPanel();
		//bottomBar.setLayout(null);
		
		animonInfo = new AnimonInfoGUI(0,350,true);
		defendingInfo = new AnimonInfoGUI(450,50,false);

		menuBar = new MenuBarGUI(400,350);
		
		add(defendingInfo);
		add(animonInfo);	
		add(menuBar);	

	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		menuBar.draw();
		if(gameState.infoChanged()){
			animonInfo.draw();
			defendingInfo.draw();
			gameState.setInfoChanged(false);
		}
	}
		
}
