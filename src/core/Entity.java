package core;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Entity {
	
	//attribute
	protected double posX;
	protected double posY;
	protected boolean death;
	protected int hight;
	protected int weight;
	protected boolean isLookRight;
	private String imagePath;
	private ImageView imageView;
	
	//Constructor
	public Entity() {
		
	}
	
	public Entity(double x,double y,int h,int w) {
		posX = x;
		posY = y;
		hight = h;
		weight = w;
	}
	
	public Entity(double x,double y,int h,int w, String path) {
		posX = x;
		posY = y;
		hight = h;
		weight = w;
		this.imagePath = path;
		this.imageView = new ImageView(new Image(ClassLoader.getSystemResource(this.imagePath).toString()));
		this.updateImageView();
	}
	
	//method
	public void move(String direction,double distance) {
		if(direction.equals("up")) {
			posY = posY - distance;
			//return;
		}
		if(direction.equals("down")) {
			posY = posY + distance;
			//return;
		}
		if(direction.equals("right")) {
			posX = posX + distance;
			//return;
		}
		if(direction.equals("left")) {
			posX = posX - distance;
			//return;
		}
		this.updateImageView();
	}
	
	//collision detect
	public boolean isCollide(Entity other) {
		return this.imageView.getBoundsInParent().intersects(other.getImageView().getBoundsInParent());
	}
	
	//getter setter
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
		this.updateImageView();
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
		this.updateImageView();
	}

	public int getHight() {
		return hight;
	}

	public void setHight(int hight) {
		this.hight = hight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setDeath(boolean death) {
		this.death = death;
	}

	public boolean isLookRight() {
		return isLookRight;
	}

	public void setLookRight(boolean isLookRight) {
		this.isLookRight = isLookRight;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		this.imageView = new ImageView(new Image(ClassLoader.getSystemResource(this.imagePath).toString()));
		this.updateImageView();
		
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	public void updateImageView() {
		imageView.setX(this.posX);
		imageView.setY(this.posY);
	}
	

	
	
	
}
