package MyStuff;

import guiPlayer.Sampler;
import guiTeacher.GUIApplication;

public class CatalogMakerGui extends GUIApplication {
	
	public static void main(String[] args){
		CatalogMakerGui sample = new CatalogMakerGui(800, 550);
		Thread go = new Thread(sample);
		go.start();
	}
	
	public CatalogMakerGui(int width, int height) {
		super(width,height);
		setVisible(true);
	}
	
	public void initScreen() {
		CatalogScreen s = new CatalogScreen(getWidth(), getHeight());
		setScreen(s);
	}
	

}
