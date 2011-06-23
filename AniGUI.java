import java.awt.*;
import javax.swing.*;
class AniGUI extends JFrame {
	JPanel bottomBar, animonInfo, menuBar;
	JLabel animonName, animonHP, animonMana;
	GameState gameState;


	AniGUI(GameState gameState){
		super("Animon");	
		this.gameState = gameState;
		setLayout(null);

		buildMainGUI();
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public void buildMainGUI(){
		bottomBar = new JPanel();
		bottomBar.setLayout(null);

		animonInfo = new JPanel();
		menuBar = new JPanel();
		
		animonName = new JLabel();
		animonHp = new JLabel();
		animonMana = new JLabel();

		animonInfo.add(animonName);
		animonInfo.add(animonHp);
		animonInfo.add(animonMana);
		
		animonInfo.setLayout(null);
		menuBar.setLayout(null);


		bottomBar.add(menuBar);		
		bottomBar.add(animonInfo);		

		add(bottomBar);	
		

	}
	
	public void paintComponent(Graphics g){
		drawBottomBar();
		drawAnimonInfo();
		drawMenuBar();
	}

}
