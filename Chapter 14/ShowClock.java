import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ShowClock extends Application {
	@Override
	public void start(Stage primaryStage) {
		ClockPane clock = new ClockPane();
		clock.setHour((int)(Math.random() * 12));
		clock.setMinute((int)(Math.random() * 31));
		clock.setSecondHandVisible(false);
		clock.setMinuteHandVisible(true);
		clock.setHourHandVisible(true);
		Scene scene = new Scene(clock, 250, 250);
		primaryStage.setTitle("DisplayHourandMinute");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
