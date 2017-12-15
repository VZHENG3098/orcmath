package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Apple extends Component {

	public Apple() {
		super(50,20, 100, 100);
		update();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
