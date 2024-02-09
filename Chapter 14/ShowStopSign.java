import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class ShowStopSign extends Application {
	@Override
	public void start(Stage stage) {
		MyPolygon octagon = new MyPolygon();
		octagon.setRotate(360 / 16);
		stage.setTitle("StopSign");
		Text label = new Text("Stop");
		label.setFont(new Font(30));
		label.setFill(Color.WHITE);
		StackPane stackpane = new StackPane(octagon, label);
		
		Scene scene = new Scene(stackpane, 400, 300);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
}
