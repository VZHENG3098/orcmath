package simon;

import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenVincent extends ClickableScreen implements Runnable {

	public ArrayList<MoveInterfaceVincent> array;
	public ProgressInterfaceVincent progress;
	
	
	public int roundNum;
	public int sequenceLength;
	public int sequenceWin;
	public boolean input;
	
	
	public ButtonInterfaceVincent[] allButtons;
	
	public int oldButton;
	Color[] colors;
	
	public TextLabel displayRound;
	public SimonScreenVincent(int width, int height) {
		super(width, height);
		
		array = new ArrayList<MoveInterfaceVincent>();
		oldButton = -1;
		allButtons = new ButtonInterfaceVincent[5];
		colors = new Color[5];
		colors[0] = Color.blue;
		colors[1] = Color.orange;
		colors[2] = Color.red;
		colors[3] = Color.green;
		colors[4] = Color.yellow;
		colors[5] = Color.pink;
		
		roundNum = 0;
		sequenceLength = 0;
		sequenceWin= 3;
		input = true;
		
		Thread app = new Thread(this);
		app.start();
	}
	

	public void run() {
		input = false;
		sequenceWin++;
		roundNum++;
		for (int i=0;i<sequenceWin;i++){
			array.add(getRandomMove());
		}
		progress.setNum(roundNum)
		progress.setSeqNum(sequenceWin);
		simonInput();
		input = true;
		
	}
	
	public void simonInput(){
		ButtonInterfaceRaymond b;
		for(int i = 0; i < array.size(); i++) {
			b = array.get(i).getButton();
			b.setBright("bright")
			Thread sleep = new Thread(new Runnable() {

				public void run() {
					try {
						Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
				}

			});
			sleep.start()
			b.setBright("dim");
		}
		
	}
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayRound = new TextLabel(50,50,200,100,Integer.toString(roundNum));
		viewObjects.add(displayRound);
		
		for (int i = 0;i <allButtons.length;i++) {
			final ButtonInterfaceVincent button = getButton(color[i]);
			button.setAction(new Action(){
				public void act(){
					if(input) {
						
						Thread light = new Thread(new Runnable(){				
							public void run() {
								button.setBright("bright");
								try {
									Thread.sleep(800);
									} catch (Exception e) {
										System.out.println(e);
									}
								button.setBright("dim");
							}
						});
						light.start();
						}
						if(button == array.get(sequenceLength).getTheButton()) { // correct input
							sequenceLength++;
						} else{ // wrong input
							progress.lose();	
						}
						if(sequenceWin == array.size()){ // got all correct
						    Thread nextRound = new Thread(SimonScreenVincent.this); 
						    nextRound.start(); 
						}
					}
			});
			allButtons[i] = button;
		}
		progress = getProgressBar();
		progress.setNum(roundNum);
		progress.setSeqNum(sequenceLength);
		

		for (int i = 0;i <allButtons.length;i++) {
			viewObjects.add(allButtons[i]);
		}
		viewObjects.add(progress);
	}

	private MoveInterfaceVincent getRandomMove() {
		int randomInt = (int)(Math.random()*allButtons.length);
		while (randomInt == oldButton) {
			randomInt = (int)(Math.random()*allButtons.length);
		}
		return pickMove(randomInt);
	}


	private MoveInterfaceVincent pickMove(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	private ProgressInterfaceVincent getProgressBar() {
		// TODO Auto-generated method stub
		return null;
	}

	private ButtonInterfaceVincent getButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
