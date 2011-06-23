import java.awt.*;
import javax.swing.*;
class Window extends JFrame {
	Window(){
		super("Animon");	
		setSize(800,500);
		//setLayout(null);
		add(new AniGUI());	
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

}
