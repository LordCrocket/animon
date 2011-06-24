import java.awt.*;
import javax.swing.*;
class AniGUI extends JPanel {
	JPanel bottomBar;
	MenuBarGUI menuBar;
	AnimonInfoGUI animonInfo,defendingInfo;
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

		menuBar = new MenuBarGUI();
			
		
		add(defendingInfo);
		add(animonInfo);	
		add(menuBar);	

	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		menuBar.draw();
		animonInfo.draw();
		defendingInfo.draw();
	}
	public void drawBottomBar(){
		//bottomBar.setBackground(Color.WHITE);
		//bottomBar.setBounds(0,350,800,150);
	}
	
}
