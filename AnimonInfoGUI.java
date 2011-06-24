import javax.swing.*;
import java.awt.*;
class AnimonInfoGUI extends JPanel {	
	private GameState gameState;
	private JLabel animonName, animonHp, animonMana;
	private int x,y;
	private boolean isCurrent;
	
	AnimonInfoGUI(int xx, int yy, boolean isCurrent){
		setLayout(null);
		x = xx;
		y = yy;
		this.isCurrent = isCurrent;
		gameState = GameState.getInstance();
		animonName = new JLabel("Default");
		animonHp = new JLabel();
		animonMana = new JLabel();

		add(animonName);
		add(animonHp);
		add(animonMana);
	}
	public void draw(){
		Animon current;
		if(isCurrent)
			current = gameState.getCurrentAnimon();
		else
			current = gameState.getDefendingAnimon();

		animonName.setText(current.getType().getName()); 
		animonHp.setText("Hp: "+current.getHp()+"/"+
							current.getType().getHp());
		animonMana.setText("Mana: "+current.getMana()+"/"+
							current.getType().getMana());
		setBounds(x,y,400,150);
		animonName.setBounds(0,0,100,25);
		animonHp.setBounds(200,20,100,25);
		animonMana.setBounds(200,45,100,25);



	}

	

}
