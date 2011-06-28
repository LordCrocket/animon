import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class MainMenuGUI extends GraphicalComponent {	
	private ArrayList<JLabel> options;
	private GameState gameState;
	private JLabel selection;

	MainMenuGUI(int x, int y){
		super(x,y);
		setLayout(null);
		selection = new JLabel("->");
		add(selection);
		options = new ArrayList<JLabel>();
		gameState = GameState.getInstance();
		for(String choice :gameState.getCurrentMenu().getOptions()){
			JLabel choiceLabel = new JLabel(choice);
			options.add(choiceLabel);
			add(choiceLabel);
		}
			
		
	}
	public void draw(){
		setBounds(x,y,100,400);
		int y = 0;
		for(JLabel option: options){
			option.setBounds(0+20,y*50,100,25);
			y++;
		}
		if(options.size()>0){	
			int choice = gameState.getCurrentChoice();	
			selection.setBounds(0,50*choice,20,20);
		}

	}
	
	
}
