package GUI;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


import core.*;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainGUI extends Application {

	public MainGUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage playStage) throws Exception {
		// TODO Auto-generated method stub
		//Make Pane
		Pane root = new Pane();
		//new Hero with simple path and start position
		Hero hero = new Hero(368,436,64,32,"pictures/Hero1.png",200);
		//new Floor
		Floor floor = new Floor(0,500,100,600,"pictures/Floor.png");
		//set the scene
		root.getChildren().add(hero.getImageView());
		root.getChildren().add(floor.getImageView());
        Scene scene = new Scene(root,800,600);
        playStage.setTitle("TestScene");
        playStage.setScene(scene);
        playStage.show();
        //set key
        KeyHandle keyHandle = new KeyHandle();
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	if(key.getCode() == KeyCode.D) {
        		keyHandle.setKeyDPressed(true);
            }
            if(key.getCode() == KeyCode.A) {
            	keyHandle.setKeyAPressed(true);
            }
            if(key.getCode() == KeyCode.W) {
                hero.jump();
            }
       
        });
        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
        	if(key.getCode()==KeyCode.D) {
        		keyHandle.setKeyDPressed(false);
            }
        	if(key.getCode()==KeyCode.A) {
            	keyHandle.setKeyAPressed(false);
            }
       
        });
        new AnimationTimer() {
            @Override public void handle(long currentNanoTime) {
            	if(keyHandle.isKeyDPressed() == true) hero.move("right", 5);
            	if(keyHandle.isKeyAPressed() == true) hero.move("left", 5);
            	//hero.jumpAction();
                //hero.gravity(floor);
            	hero.jumpUpdate(floor);
            }
        }.start();
        
        
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
