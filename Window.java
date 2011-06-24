import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Window extends JFrame {
	Controller game;
	Window(){
		super("Animon");	
		setSize(800,500);
		AniGUI GUI = new AniGUI();
		//setLayout(null);
		add(GUI);	
		game = new Controller(GUI);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		addKeyListener(new MenuListener());
	}
	class MenuListener extends KeyAdapter{
		public void keyPressed(KeyEvent ke){
			game.buttonPushed(ke.getKeyCode());
		}


	}


}
