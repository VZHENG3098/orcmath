package simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJessica extends Button implements ButtonInterfaceVincent {

	private Action action;
	private Color color;
	public ButtonJessica(int x, int y, int w, int h, String text, Object object) {
		
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor1(Color c) {
		color = c;
		this.setBackground(c);
		update();
	}
	
	@Override
	public void setAction(Action a) {
		this.action = a;
	}
	

	
	public void setBright(String string) {
		//bright or dim
		if(string.equals("dim"))
		{
			this.setBackground(this.color);
			update();
		}
		else
		{
			this.setBackground(Color.WHITE);
			update();
		}

	}
	public void act() {
		this.action.act();
		
	}
}
