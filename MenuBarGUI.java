import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class MenuBarGUI extends GraphicalComponent {
	private Menu menu;
	private GameState gameState;
	private ArrayList<JLabel> options; 
	private JLabel selection;
	private int width = 0;
	private JLabel playerName;
	
	MenuBarGUI(int x,int y){
		super(x,y);
		gameState = GameState.getInstance();
		setLayout(null);
		selection = new JLabel("->");
		selection.setBackground(Color.BLACK);
		playerName = new JLabel("");
		add(playerName);
	}
	public void draw(){
		setBounds(x,y,400,150);
		updateMenu();	
	}

	public void updateMenu(){
		Menu newMenu = gameState.getCurrentMenu();	
		if(menu==null  || !menu.equals(newMenu)){
			
			menu = newMenu;
			removeAll();
			add(selection);
			add(playerName);
			options = new ArrayList<JLabel>();
			ArrayList<String> optionNames = menu.getOptions();	
			width = 400/menu.getColoumns();

			int x=0,y=0;
			for(String option: optionNames){
				JLabel menuLabel = new JLabel(option);
				options.add(menuLabel);
				add(menuLabel);
				menuLabel.setBounds(20+x,1+y,width,50);
				x = (x+width)%400; 
				if(x == 0){
					y+=50;
				}
			}
		}
		if(gameState.getCurrentMenu().getNumberOfOptions()>0){
			int choice = gameState.getCurrentChoice();	
			int coloumns = menu.getColoumns();
			int x = choice%coloumns;	
			int y = choice/coloumns;
			selection.setBounds(width*x,50*y+15,20,20);
			playerName.setText(gameState.getCurrentPlayer().getName());	
			playerName.setBounds(width/2,0,100,25);
			
		}

	}


}
