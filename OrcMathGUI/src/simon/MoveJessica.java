package simon;

public class MoveJessica implements MoveInterfaceVincent {

	public ButtonInterfaceVincent getNumButton(int a) {
		return SimonGameVincent.simon.allButtons[a];	
	}
	@Override
	public ButtonInterfaceVincent getTheButton() {
		return this;
	}
	@Override
	public ButtonInterfaceVincent getButton() {
		// TODO Auto-generated method stub
		return null;
	}

}
