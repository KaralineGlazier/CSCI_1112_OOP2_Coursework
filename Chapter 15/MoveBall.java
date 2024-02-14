import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;



public class MoveBall extends Application {
	private BallPane ballpane = new BallPane();
	public void start(Stage primaryStage) {
		HBox buttons = new HBox(50);
		buttons.setAlignment(Pos.CENTER);
		Button btUp = new Button("Move Up");
		Button btDown = new Button("Move Down");
		Button btLeft = new Button("Move Left");
		Button btRight = new Button("Move Right");
		buttons.getChildren().addAll(btUp, btDown, btLeft, btRight);
		
		//if button up is pressed, method ballpane.moveUp is implemented
		btUp.setOnAction(e -> {
			ballpane.moveUp();
		});
		btDown.setOnAction(e -> {
			ballpane.moveDown();
		});
		btLeft.setOnAction(e -> {
			ballpane.moveLeft();
		});
		btRight.setOnAction(e -> {
			ballpane.moveRight();
		});
		
		//Create a BorderPane
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(0, 50 , 25, 50));
		borderPane.setBottom(buttons);
		borderPane.setCenter(ballpane);
		
		//Create Scene 
				Scene scene = new Scene(borderPane, 1000, 1000);
				primaryStage.setTitle("Move the Ball");
				primaryStage.setScene(scene);
				primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	
	
}