import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class MenuBarGUI extends GraphicalComponent {
	private Menu menu;
	private GameState gameState;
	private ArrayList<JLabel> options; 
	private JLabel selection;
	
	MenuBarGUI(int x,int y){
		super(x,y);
		gameState = GameState.getInstance();
		setLayout(null);
		selection = new JLabel("->");
		selection.setBackground(Color.BLACK);
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
			options = new ArrayList<JLabel>();
			ArrayList<String> optionNames = menu.getOptions();	
			int x=0,y=0;
			for(String option: optionNames){
				JLabel menuLabel = new JLabel(option);
				options.add(menuLabel);
				add(menuLabel);
				int width = 400/menu.getColoumns();
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
			selection.setBounds(200*x,50*y+15,20,20);
		}

	}


}
