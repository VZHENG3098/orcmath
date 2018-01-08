package simon;

import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class ProgressJessica extends Component implements ProgressInterfaceVincent {
	
	
	public ProgressJessica(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	
	public void setSeqNum(int sequenceLength) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}


	@Override
	public ProgressJessica setNum(int roundNum) {
		ProgressJessica progress = new ProgressJessica(0,0,50,50);
		return progress;
		
	}




}
