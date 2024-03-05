import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {
	@Override
	public void start(Stage primaryStage) {
		SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
		Button btMinus = new Button(" - ");
		Button btPlus = new Button("+  ");
		pane.paint();
		btMinus.setOnAction(e -> {
		if (pane.order == 0) {
			pane.setOrder(0);
		}
		else {
			pane.setOrder(pane.order - 1);
		}
		});
		
		btPlus.setOnAction(e -> {
			pane.setOrder(pane.order + 1);
		});
		
		btMinus.setAlignment(Pos.BOTTOM_LEFT);
		btPlus.setAlignment(Pos.BOTTOM_RIGHT);
		
		//pane for buttons and text field
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btMinus, new Label("Press + to increase and - to decrease"), btPlus);
		hBox.setAlignment(Pos.CENTER);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		
		//create scene
		Scene scene = new Scene(borderPane, 300, 300);
		primaryStage.setTitle("SierpinskiTriangle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.widthProperty().addListener(ov -> pane.paint());
		scene.heightProperty().addListener(ov -> pane.paint());
	}
	static class SierpinskiTrianglePane extends Pane {
		private int order = 0;

		//set new order
		public void setOrder(int order) {
			this.order = order;
			paint();
		}
		
		//get order
		public int getOrder() {
			return order;
		}
		
		SierpinskiTrianglePane() {
			
		}
		
		protected void paint() {
			Point2D p1 = new Point2D(getWidth() / 2, 10);
			Point2D p2 = new Point2D(10, getHeight() - 10);
			Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
			
			this.getChildren().clear();
			
			displayTriangles(order, p1, p2, p3);
		}
		
		private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
			if (order == 0) {
				Polygon triangle = new Polygon();
				triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(),
						p2.getY(), p3.getX(), p3.getY());
				triangle.setStroke(Color.BLACK);
				triangle.setFill(Color.WHITE);
				
				this.getChildren().add(triangle);
			}
			else  {
				Point2D p12 = p1.midpoint(p2);
				Point2D p23 = p2.midpoint(p3);
				Point2D p31 = p3.midpoint(p1);
				
				//Recursively display three triangles
				displayTriangles(order - 1, p1, p12, p31);
				displayTriangles(order - 1, p12, p2, p23);
				displayTriangles(order - 1, p31, p23, p3);
				
			}
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
