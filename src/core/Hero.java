package core;

public class Hero extends Entity{
	//attribute
	private boolean onFloor; //true when on floor
	private boolean onPlatform; //true when on wood platform
	private int jumpCount; 
	private double jumpPower;
	private boolean jumping;
	private double jumpTo;
	private boolean onMidAir;
	private boolean attacking;
	
	//Constructor
	public Hero() {
	}
	
	public Hero(double x, double y,int h,int w, int life,String path ,int jumppower) {
		super(x,y,h,w,life,path);
		this.jumpPower = jumppower;
	}
	//method press button
	public void jump() {
		if (jumpCount < 2) { 
			jumpTo = this.posX + jumpPower;
			jumping = true;
			jumpCount += 1;
			return;
		}
		return;
	}
	
	public void attack() {
		if(this.attacking) {
			return;
		}
		else {
			if(this.isLookRight) {
				
			}
			else {
			}
		}
	}
	
	//method loop
	public void gravity() {
		if(jumping == false ) {
			move("down",10);
			return;
		}
		return;
	}

	public void jumpAction() {
		if(jumping == true) {
			if(this.posY <= jumpTo) {
				move("up",10);
			}
			else {
				jumping = false;
				jumpCount = 0;
			}
		}
	}
	
	public void checkGround() {
		//floor midair platform
	}
	
	//getter setter
	public boolean isOnFloor() {
		return onFloor;
	}

	public void setOnFloor(boolean onFloor) {
		this.onFloor = onFloor;
	}

	public boolean isOnPlatform() {
		return onPlatform;
	}

	public void setOnPlatform(boolean onPlatform) {
		this.onPlatform = onPlatform;
	}

	public int getJumpCount() {
		return jumpCount;
	}

	public void setJumpCount(int jumpCount) {
		this.jumpCount = jumpCount;
	}

	public double getJumpPower() {
		return jumpPower;
	}

	public void setJumpPower(double jumpPower) {
		this.jumpPower = jumpPower;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public boolean isOnMidAir() {
		return onMidAir;
	}

	public void setOnMidAir(boolean onMidAir) {
		this.onMidAir = onMidAir;
	}

	public double getJumpTo() {
		return jumpTo;
	}

	public void setJumpTo(double jumpTo) {
		this.jumpTo = jumpTo;
	}
	
	

	
}
