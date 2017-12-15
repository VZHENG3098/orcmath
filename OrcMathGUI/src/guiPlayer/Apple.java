package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Apple extends AnimatedComponent {

	public Apple() {
		super(50,20, 1536, 256);
		addSequence("resources/sprite.png", 150, 0, 0, 261, 256, 6);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		super.update(g);
		//g.setColor(Color.DARK_GRAY);
		//g.fillRect(0, 0, getWidth(), getHeight());
	}

}
