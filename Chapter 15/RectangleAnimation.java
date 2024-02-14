import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Group;


public class RectangleAnimation extends Application{
	@Override
	public void start(Stage primaryStage) {
		Polygon pentagon = new Polygon();
		Pane pane = new Pane();
		pentagon.getPoints().addAll(new Double[] {
				200.0, 300.0,
				300.0, 600.0,
				700.0, 600.0,
				800.0, 300.0,
				500.0, 100.0,
		});
		pentagon.setFill(Color.RED);
		
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.BLUE);
		
	     
		
		Text text1 = new Text(300, 20, "Click the right mouse to pause and the left to resume");
		text1.setFont(Font.font("Courier", 15));
		
		pane.getChildren().add(text1);
		pane.getChildren().add(pentagon);
		pane.getChildren().add(rectangle);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(6000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(
		PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(6000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		pane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.SECONDARY) {
				pt.pause();
				ft.pause();
			}
			else if (e.getButton() == MouseButton.PRIMARY) {
				pt.play();
				ft.play();
			}
		});
		Scene scene = new Scene(pane, 1000, 1000);
		primaryStage.setTitle("RectangleAnimation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}