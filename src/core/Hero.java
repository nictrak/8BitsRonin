package core;

import java.util.ArrayList;

public class Hero extends Entity{
	//attribute
	private int jumpCount; 
	private double jumpTo;
	private boolean attacking;
	private FeetStatus feetStatus;
	private double velocityY;
	
	//Constructor
	public Hero() {
	}
	
	public Hero(double x, double y,int h,int w,String path ,int jumppower) {
		super(x,y,h,w,path);
		this.jumpTo = this.posY;
		this.feetStatus = FeetStatus.FLOOR;
		this.velocityY = 0;
	}
	//method press button
	public void jump() {
		if (jumpCount < 2) { 
			jumpCount += 1;
			this.feetStatus = FeetStatus.AIR;
			this.velocityY = 13 ;
		}
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
	/*public void gravity(Floor floor) {
		if(jumping == false && this.feetStatus == FeetStatus.AIR ) {
			move("down",5);
		}
		if(this.isCollide(floor) == true) {
			this.feetStatus = FeetStatus.FLOOR ;
		}
	}

	public void jumpAction() {
		if(jumping == true) {
			if(this.posY >= jumpTo) {
				move("up",100);
			}
			else {
				jumping = false;
				jumpCount = 0;
			}
		}
	} not used anymore*/
	
	//new jump method
	public void jumpUpdate(Floor floor) {
		if(this.feetStatus == FeetStatus.AIR) {
			move("up",this.velocityY);
			this.velocityY = this.velocityY - 0.5;
		}
		if(this.isCollide(floor) == true) {
			this.feetStatus = FeetStatus.FLOOR ;
			this.jumpCount = 0;
			this.setPosY(floor.getPosY() - this.getHight());
		}
	}
	
	
	
	//getter setter
	public int getJumpCount() {
		return jumpCount;
	}

	public void setJumpCount(int jumpCount) {
		this.jumpCount = jumpCount;
	}


	public double getJumpTo() {
		return jumpTo;
	}

	public void setJumpTo(double jumpTo) {
		this.jumpTo = jumpTo;
	}
	
	

	
}
