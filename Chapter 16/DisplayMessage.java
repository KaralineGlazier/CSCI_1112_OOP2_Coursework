import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleGroup;

public class DisplayMessage extends Application{
	private Text text = new Text(50, 50, "Programming is fun");
	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		//create graphical objects
		Button btLeft = new Button(" < --- ");
		Button btRight = new Button(" --- > ");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("Blue");
		RadioButton rbRed = new RadioButton("Red");
		
		Pane textPane = new Pane();
		textPane.getChildren().add(text);
		borderPane.setCenter(textPane);
		
		HBox buttonPane1 = new HBox(20);
		buttonPane1.getChildren().addAll(btLeft, btRight);
		buttonPane1.setAlignment(Pos.CENTER);
		borderPane.setBottom(buttonPane1);
		
		HBox buttonPane2 = new HBox(20);
		buttonPane2.setPadding(new Insets(5, 5, 5, 5));
		buttonPane2.getChildren().addAll(rbBlack, rbGreen, rbBlue, rbRed);
		buttonPane2.setAlignment(Pos.CENTER);
		borderPane.setTop(buttonPane2);
		
		//Create ToggleGroup
		ToggleGroup group = new ToggleGroup();
		rbBlack.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		rbRed.setToggleGroup(group);
		
		//listen to and handle events
		//text should not go off the pane
		btLeft.setOnAction(e -> {
			if (text.getX() > 0) {
				text.setX(text.getX() - 10);
			}
			else {
				text.setX(text.getX());
			}
		});
		
		btRight.setOnAction(e -> {
			if (text.getX() < 340) {
				text.setX(text.getX() + 10);
			}
			else {
				text.setX(text.getX());
			}
		});
		
		rbBlack.setOnAction(e -> {
			if (rbBlack.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		
		rbGreen.setOnAction(e -> {
			if (rbGreen.isSelected());{
			text.setFill(Color.GREEN);
			}
		});
		
		rbBlue.setOnAction(e -> {
			if (rbBlue.isSelected());{
				text.setFill(Color.BLUE);
			}
		});
		
		rbRed.setOnAction(e -> {
			if (rbRed.isSelected()) {
				text.setFill(Color.RED);
			}
		});
		//Create scene and place in the stage
		Scene scene = new Scene(borderPane, 450, 200);
		primaryStage.setTitle("DisplayMessage");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
