package GUI;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import core.*;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
		Hero hero = new Hero(368,400,64,32,3,"pictures/Hero1.png",2);
		//set the scene
		root.getChildren().add(hero.getImageView());
        Scene scene = new Scene(root,800,600);
        playStage.setTitle("TestScene");
        playStage.setScene(scene);
        playStage.show();
        //set key
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
        	try {
				TimeUnit.MILLISECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if(key.getCode()==KeyCode.D) {
                hero.move("right", 5);
            }
            if(key.getCode()==KeyCode.A) {
                hero.move("left", 5);
            }
            if(key.getCode()==KeyCode.W) {
                hero.jump();
            }
            System.out.print(hero.getJumpTo());
            System.out.println(hero.getPosY());
            hero.jumpAction();
            hero.gravity();
        });
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
