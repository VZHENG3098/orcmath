package simon;

import java.util.ArrayList;
import java.util.List;

import com.sun.prism.paint.Color;

import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenVincent extends ClickableScreen {

	public ArrayList<MoveInterfaceVincent> array;
	public ProgressInterfaceVincent progress;
	public int roundNum;
	public int sequenceLength;
	public boolean input;
	
	public ButtonInterfaceVincent redB;
	
	public TextLabel displayRound;
	public SimonScreenVincent(int width, int height) {
		super(width, height);
		array = new ArrayList<MoveInterfaceVincent>();
		roundNum = 0;
		sequenceLength = 0;
		input = false;
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		displayRound = new TextLabel(50,50,200,100,Integer.toString(roundNum));
		viewObjects.add(displayRound);
		
		redB = getButton();
		redB.setColor(Color.RED);
		redB.setBright("bright");
		
		progress = getProgressBar();
		progress.setNum(roundNum);
		progress.setSeqNum(sequenceLength);
		

		viewObjects.add(redB);
		viewObjects.add(progress);
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
