import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
class NewGameGUI extends GraphicalComponent {	
	private GameState gameState;
	private JComboBox<String> numberField;
	private int currentNumberOfPlayers = 0;
	private ArrayList<JTextField> nameFields;
	private boolean numberFieldShow = false;
	private Window mainWindow;
	private JButton okButton;

	NewGameGUI(int x, int y, Window mainWindow){
		super(x,y);
		setLayout(null);
		gameState = GameState.getInstance();
		String [] options = {"2","3","4","5","6"};
		numberField = new JComboBox<String>(options);
		this.mainWindow = mainWindow;
		okButton = new JButton("OK");	
		
		//numberField.addKeyListener(new MenuListener());
		okButton.addKeyListener(new MenuListener());
		nameFields = new ArrayList<JTextField>();
		add(okButton);
		add(numberField);	
	}

	public ArrayList<String> getNames(){
		ArrayList<String> names = new ArrayList<String>();
		
		for(JTextField nameField : nameFields)
			names.add(nameField.getText());	
		return names;
	}

	public boolean isFilled(){
		for(JTextField nameField : nameFields)
			if(nameField.getText()==null || nameField.getText().equals(""))
				return false;
		return true;
		
	}

	public void draw(){
		setBounds(x,y,100,500);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		if(!numberFieldShow){
			numberField.setBounds(0,0,100,25);
			numberFieldShow = true;	
		}	
		int players = numberField.getSelectedIndex() +2;		
		
		if(players>currentNumberOfPlayers){
			int dif;
			for(; currentNumberOfPlayers<players; currentNumberOfPlayers++){
				JTextField nameField= new JTextField();
				nameFields.add(nameField);	
				add(nameField);
				nameField.setBounds(0,30+30*currentNumberOfPlayers,100,25);
			}
		}	
		else if(players<currentNumberOfPlayers){
			for(; currentNumberOfPlayers>players; currentNumberOfPlayers--){
					JTextField toRemove = nameFields.get(currentNumberOfPlayers-1);					
					nameFields.remove(currentNumberOfPlayers-1);
					remove(toRemove);	
			}
			getParent().repaint();
		}
			okButton.setBounds(0,60+30*currentNumberOfPlayers,100,25);

	}
	
}
