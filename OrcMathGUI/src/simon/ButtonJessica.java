package simon;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonJessica extends Button implements ButtonInterfaceVincent {

	public ButtonJessica(int x, int y, int w, int h, String text, Object object) {
		
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
		update();
	}

	@Override
	public void setColor1(Color red) {
		this.setBackgroundColor(red);
		update();
	}

	@Override
	public void setBright(String string) {
		//bright or dim
		if(string.equals("dim"))
		{
			this.setBackgroundColor(Color.WHITE);
		}
		else
		{
			this.setBackgroundColor(Color.BLACK);
		}

	}


	

	
}
