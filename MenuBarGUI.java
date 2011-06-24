import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class MenuBarGUI extends JPanel {
	private Menu menu;
	private GameState gameState;
	private ArrayList<JLabel> options; 
	private JLabel selection;
	public static final int COLOUMNS = 2;
	
	MenuBarGUI(){
		gameState = GameState.getInstance();
		setLayout(null);
		selection = new JLabel("->");
		selection.setBackground(Color.BLACK);
	}
	public void draw(){
		setBounds(400,350,400,150);
		updateMenu();	
	}

	public void updateMenu(){
		Menu newMenu = gameState.getCurrentMenu();	
		if(menu==null  || !menu.equals(newMenu)){
			
			menu = newMenu;
			removeAll();
			add(selection);
			options = new ArrayList<JLabel>();
			ArrayList<String> optionNames = menu.getOptions();	
			int x=0,y=0;
			for(String option: optionNames){
				JLabel menuLabel = new JLabel(option);
				options.add(menuLabel);
				add(menuLabel);
				int width = 400/COLOUMNS;
				menuLabel.setBounds(20+x,1+y,width,50);
				x = (x+width)%400; 
				if(x == 0){
					y+=50;
				}
			}
		}
		int choice = gameState.getCurrentChoice();	
		int x = choice%COLOUMNS;	
		int y = choice/COLOUMNS;
		selection.setBounds(200*x,50*y+15,20,20);

	}


}
