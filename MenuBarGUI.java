import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class MenuBarGUI extends GraphicalComponent {
	private Menu menu;
	private GameState gameState;
	private ArrayList<JLabel> options; 
	private JLabel selection;
	private int width = 0, xSize,ySize;
	private JLabel playerName;
	
	MenuBarGUI(int x,int y,int xSize,int ySize){
		super(x,y);
		this.xSize = xSize;
		this.ySize = ySize;
		gameState = GameState.getInstance();
		setLayout(null);
		selection = new JLabel("->");
		selection.setBackground(Color.BLACK);
		playerName = new JLabel("");
	}
	public void draw(){
		setBounds(x,y,xSize,ySize);
		updateMenu();	
	}

	public void updateMenu(){
		Menu newMenu = gameState.getCurrentMenu();	
		if(menu==null  || !menu.equals(newMenu)){
			
			menu = newMenu;
			removeAll();
			add(selection);
			if(menu.getType()==MenuType.animonChoice)
				add(playerName);
			options = new ArrayList<JLabel>();
			ArrayList<String> optionNames = menu.getOptions();	
			width = xSize/menu.getColoumns();

			int x=0,y=0;
			for(String option: optionNames){
				JLabel menuLabel = new JLabel(option);
				options.add(menuLabel);
				add(menuLabel);
				menuLabel.setBounds(20+x,1+y,width,50);
				x = (x+width)%xSize; 
				if((x+width) > xSize)
					x =0;
				if(x < width){
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
			if(menu.getType()==MenuType.animonChoice){
				playerName.setText(gameState.getCurrentPlayer().getName());	
				playerName.setBounds(width/2,0,100,25);
			}
			
		}

	}


}
