import java.awt.*;
import javax.swing.*;
class AniGUI extends JPanel {
	JPanel bottomBar, animonInfo, menuBar;
	JLabel animonName, animonHp, animonMana;
	GameState gameState = GameState.getInstance();


	AniGUI(){	
		setLayout(null);
		//setBackground(Color.BLACK);	
		setSize(800,500);
		buildMainGUI();
	}

	public void buildMainGUI(){
		bottomBar = new JPanel();
		bottomBar.setLayout(null);
		
		animonInfo = new JPanel();
		menuBar = new JPanel();
		
		animonName = new JLabel("Default");
		animonHp = new JLabel();
		animonMana = new JLabel();

		animonInfo.add(animonName);
		animonInfo.add(animonHp);
		animonInfo.add(animonMana);
		
		animonInfo.setLayout(null);
		menuBar.setLayout(null);
		

		bottomBar.add(menuBar);		
		bottomBar.add(animonInfo);		
		add(animonInfo);	
		add(menuBar);	
		add(bottomBar);	

	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		drawAnimonInfo();
		drawMenuBar();
	}
	public void drawBottomBar(){
		bottomBar.setBackground(Color.WHITE);
		bottomBar.setBounds(0,350,800,150);
	}
	public void drawAnimonInfo(){
		//animonInfo.setBackground(Color.BLUE);
		animonName.setText(gameState.getCurrentAnimonName()); 
		animonHp.setText("Hp: "+gameState.getCurrentAnimonHp()+"/"+
							gameState.getCurrentAnimonMaxHp());
		animonMana.setText("Mana: "+gameState.getCurrentAnimonMana()+"/"+
							gameState.getCurrentAnimonMaxMana());
		animonInfo.setBounds(0,350,400,150);
		animonName.setBounds(0,0,100,100);
		animonHp.setBounds(100,0,100,100);
		animonMana.setBounds(200,0,100,100);

	}
	public void drawMenuBar(){
		menuBar.setBackground(Color.GREEN);
		menuBar.setBounds(400,350,400,150);
	}

}
