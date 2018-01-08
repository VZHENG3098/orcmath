package simon;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



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
/*		progress.setNum(roundNum);
		progress.setSeqNum(sequenceWin);*/
		simonInput();
		input = true;
		
	}
	
	public void simonInput(){
		ButtonInterfaceVincent b;
		for(int i = 0; i < array.size(); i++) {
			b = array.get(i).getButton();
			b.setBright("bright");
			Thread sleep = new Thread(new Runnable() {

				public void run() {
					try {
						Thread.sleep(800);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
				}

			});
			sleep.start();
			b.setBright("dim");
		}
		
	}
	
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		array = new ArrayList<MoveInterfaceVincent>();
		oldButton = -1;
		allButtons = new ButtonInterfaceVincent[4];
		colors = new Color[4];
		colors[0] = Color.BLUE;
		colors[1] = Color.YELLOW;
		colors[2] = Color.RED;
		colors[3] = Color.GREEN;
	
		roundNum = 0;
		sequenceLength = 0;
		sequenceWin= 3;
		input = true;
		
		
		displayRound = new TextLabel(50,50,200,100,Integer.toString(roundNum));
		viewObjects.add(displayRound);
		
		for (int i = 0;i <allButtons.length;i++) {
			
			final ButtonInterfaceVincent button = getButton();
			button.setColor1(colors[i]);
			button.setX(i*55);
			button.setY(i*50);
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
	/*	progress = getProgressBar();
		progress.setNum(roundNum);
		progress.setSeqNum(sequenceLength);*/
		

		for (int i = 0;i <allButtons.length;i++) {
			viewObjects.add(allButtons[i]);
		}
	//	viewObjects.add(progress);
	}

	private MoveInterfaceVincent getRandomMove() {
		int randomInt = (int)(Math.random()*allButtons.length);
		while (randomInt == oldButton) {
			randomInt = (int)(Math.random()*allButtons.length);
		}
		return pickMove(randomInt);
	}




	private MoveInterfaceVincent pickMove(int randomInt) {
		MoveJessica move = new MoveJessica();
		return move.getNumButton(randomInt);
		
		
	}


	/*private ProgressInterfaceVincent getProgressBar() {
		return ProgressInterfaceVincent.setNum
	}*/

	


	private ButtonInterfaceVincent getButton() {
		ButtonJessica button = new ButtonJessica(0,0,50,50,"",null);
		return button;
	}



}
