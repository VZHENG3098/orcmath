package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Pokemon extends Component {
	
	private String name;
	private String type;
	private double price;
	public Pokemon(String name, String type, double price) {
		super(50,20, 256, 256);
		this.name = name;
		this.type = type;
		this.price = price;
				
		/*addSequence("resources/sprite.png", 150, 0, 0, 256, 256, 6);
		Thread animation = new Thread(this);
		animation.start();
		update();*/
	}

	@Override
	public void update(Graphics2D g) {
		
		//super.update(g);
		//g.setColor(Color.DARK_GRAY);
		//g.fillRect(0, 0, getWidth(), getHeight());
	}

	public String toString() {
		return name+","+type+","+price;
		
	}
	
	
}
