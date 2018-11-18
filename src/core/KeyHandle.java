package core;

public class KeyHandle {
	
	private boolean isKeyDPressed;
	private boolean isKeyAPressed;
	
	public KeyHandle() {
		// TODO Auto-generated constructor stub
		this.isKeyDPressed = false;
		this.isKeyAPressed = false;
		
	}

	public boolean isKeyDPressed() {
		return isKeyDPressed;
	}

	public void setKeyDPressed(boolean isKeyDPressed) {
		this.isKeyDPressed = isKeyDPressed;
	}

	public boolean isKeyAPressed() {
		return isKeyAPressed;
	}

	public void setKeyAPressed(boolean isKeyAPressed) {
		this.isKeyAPressed = isKeyAPressed;
	}
	

}
