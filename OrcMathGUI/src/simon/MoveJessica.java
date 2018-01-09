package simon;

public class MoveJessica implements MoveInterfaceVincent {

	ButtonInterfaceVincent button;
	
	public MoveJessica(ButtonInterfaceVincent button) {
		this.button = button;
	}
	public ButtonInterfaceVincent getTheButton() {
		return button;
	}
 
}
