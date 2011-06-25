import javax.swing.*;
abstract class GraphicalComponent extends JPanel {
	protected int x,y;
	GraphicalComponent(int xx,int yy){
		x = xx;
		y = yy;
	}

	public abstract void draw();
	
}
