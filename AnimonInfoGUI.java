import javax.swing.*;
import java.awt.*;
class AnimonInfoGUI extends GraphicalComponent {	
	private GameState gameState;
	private JLabel animonName, animonHp, animonMana,playerName;
	private boolean isCurrent;
	
	AnimonInfoGUI(int x, int y, boolean isCurrent){
		super(x,y);
		setLayout(null);
		this.isCurrent = isCurrent;
		gameState = GameState.getInstance();
		animonName = new JLabel("Default");
		animonHp = new JLabel();
		animonMana = new JLabel();
		playerName = new JLabel("");
		add(playerName);

		add(animonName);
		add(animonHp);
		add(animonMana);
	}
	public void draw(){
		Animon currentAnimon;
		Player currentPlayer;
		int offSet;
		
		if(isCurrent){
			currentAnimon = gameState.getCurrentAnimon();
			currentPlayer = gameState.getCurrentPlayer();
			offSet = 300;	
		}
		else{
			currentAnimon = gameState.getDefendingAnimon();
			currentPlayer = gameState.getNextPlayer();
			offSet = 150;
		}
		
		animonName.setText(currentAnimon.getType().getName()); 
		animonHp.setText("Hp: "+currentAnimon.getHp()+"/"+
							currentAnimon.getType().getHp());
		animonMana.setText("Mana: "+currentAnimon.getMana()+"/"+
							currentAnimon.getType().getMana());
		setBounds(x,y,400,150);
		animonName.setBounds(0,0,100,25);
		animonHp.setBounds(200,20,100,25);
		animonMana.setBounds(200,45,100,25);
		playerName.setText(currentPlayer.getName());	
		playerName.setBounds(offSet,0,100,25);
	}

	

}
