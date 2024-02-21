/*
 * Author: Karaline Glazier
 * Date: 02/21/2024
 * 
 * This program prompts the user to enter a number,
 * and then counts down from the number entered until the count down gets to 0. 
 * Once the count down gets to zero, the animation stops, the music plays, and the text changes to red to show that the program has stopped. 
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class DisplayCountdown extends Application {
	//create objects
	protected TextField tfCount = new TextField();
	protected Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
	protected MediaPlayer mediaPlayer = new MediaPlayer(media);
	protected MediaView mediaView = new MediaView(mediaPlayer);
	protected Text message = new Text("Enter a number to count down from");
	protected Timeline animation;
	@Override
	public void start(Stage primaryStage) {
		//create pane
		StackPane pane = new StackPane();
		//Add text field to pane
		pane.getChildren().add(tfCount);
		mediaPlayer.setVolume(0);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		pane.getChildren().add(message);
		pane.getChildren().add(mediaView);
		
		//handle text field
		 EventHandler<ActionEvent> eventHandler = e -> {
			 tfCount.setText(tfCount.getText());
			if (Integer.parseInt(tfCount.getText()) > 0) {
				mediaPlayer.pause(); //pauses sound 
				tfCount.setText(String.valueOf(Integer.parseInt(tfCount.getText()) -1));
				
				
			}
				//does the same thing? 
			
			//play sound after loop
			if (tfCount.getText().equals("0")) {
				animation.pause(); //stops the count down
				mediaPlayer.play(); //plays sound when count down reaches 0
				tfCount.setStyle("-fx-text-fill: red");
			}
		};
	
		
		//Create loop for counting down (every second)
		animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		tfCount.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				animation.play();
			}
		});
		
		//Create scene
		Scene scene = new Scene(pane, 650, 500);
		primaryStage.setTitle("Countdown");
		primaryStage.setScene(scene);
		primaryStage.show(); 
		
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}