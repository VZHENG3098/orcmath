package simon;

import guiTeacher.GUIApplication;

public class SimonGameVincent extends GUIApplication {
	
	public static SimonGameVincent sample;
	public static SimonScreenVincent simon;
	
	public SimonGameVincent(int width, int height) {
		super(width,height);
		setVisible(true);
	}
	 
	public static void main(String[] args){
		sample = new SimonGameVincent(1000, 1000);
		Thread go = new Thread(sample);
		go.start();
		
		
	}
	
	
	public void initScreen() {
		// TODO Auto-generated method stub
		simon = new SimonScreenVincent(getWidth(), getHeight());
		setScreen(simon);
	}

}
