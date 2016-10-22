import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Window extends JFrame {
	private Controller game;
	private int xSize, ySize;
	Window(){
		super("Animon");	
		xSize = 1000;
		ySize = 600;
		setSize(xSize,ySize);
		AniGUI GUI = new AniGUI(this);
		//setLayout(null);
		add(GUI);	
		game = new Controller(GUI);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		addKeyListener(new MenuListener(game));
	}
	
	public int getXSize(){
		return xSize;
	}
	public int getYSize(){
		return ySize;
	}	




}
