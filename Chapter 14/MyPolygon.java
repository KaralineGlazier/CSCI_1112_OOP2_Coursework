
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyPolygon extends Pane {
    private void paint() {
     // Create a polygon and place polygon to pane
      Polygon polygon = new Polygon();
      polygon.setFill(Color.RED);
      polygon.setStroke(Color.BLACK);
      ObservableList<Double> list = polygon.getPoints();
 
      double centerX = getWidth() / 2, centerY = getHeight() / 2;
      double radius = Math.min(getWidth(), getHeight()) * 0.4;

     // Add points to the polygon list
     for (int i = 0; i < 8; i++) {
        list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
       list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
      }

      getChildren().clear();
      getChildren().add(polygon);
    }
   @Override
    public void setWidth(double width) {
     super.setWidth(width);
     paint();
   }
    
  @Override
    public void setHeight(double height) {
    super.setHeight(height);
  paint();
    }
  }