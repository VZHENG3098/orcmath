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
	public boolean input;
	
	
	public ButtonInterfaceVincent[] allButtons;
	
	public int oldButton;
	
	public TextLabel displayRound;
	public SimonScreenVincent(int width, int height) {
		super(width, height);
		
		array = new ArrayList<MoveInterfaceVincent>();
		oldButton = -1;
		allButtons = new ButtonInterfaceVincent[5];
		roundNum = 0;
		sequenceLength = 3 ;
		input = false;
		// TODO Auto-generated constructor stub
	}
	

	public void run() {
		  Thread startRound = new Thread(SimonScreenVincent.this); 
		  startRound.start(); 
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayRound = new TextLabel(50,50,200,100,Integer.toString(roundNum));
		viewObjects.add(displayRound);
		
		for (int i = 0;i <allButtons.length;i++) {
			final ButtonInterfaceVincent button = getButton();
			button.setAction(new Action(){
				public void act(){
					Thread blink = new Thread(new Runnable(){				
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
					blink.start();
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
