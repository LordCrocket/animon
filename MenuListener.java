import java.awt.event.*;
class MenuListener extends KeyAdapter{
	private static Controller game;
	public void keyPressed(KeyEvent ke){
			game.buttonPushed(ke.getKeyCode());
	}
	MenuListener(){}
	MenuListener(Controller game){
		this.game = game; 
	}
}
