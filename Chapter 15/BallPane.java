import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class BallPane extends Pane {
	//Create a Circle object
	private Circle circle = new Circle(100, 100, 40);
	//Add ball to the pane and create circle properties
	public BallPane() {
		circle.setFill(Color.BLUE);
		circle.setStroke(Color.BLACK);
		getChildren().add(circle);
	}
	//Move Ball Up
	public void moveUp() {
		//if statement to check if circle is going off the scene or not
		if(circle.getCenterY() > circle.getRadius() ) {
		circle.setCenterY(circle.getCenterY() - 100);
		}
		else {
			circle.setCenterY(circle.getCenterY());
		}
		circle.setCenterX(circle.getCenterX());
	}
	//Move ball down
	public void moveDown() {
		circle.setCenterX(circle.getCenterX());
		//if statement to check if circle is going off the scene or not
		if (circle.getCenterY() < getHeight() - circle.getRadius()) {
		circle.setCenterY(circle.getCenterY() + 100);
		}
		else {
			circle.setCenterY(circle.getCenterY());
		}
	}
	//Move ball right
	public void moveRight() {
		circle.setCenterY(circle.getCenterY());
		//if statement to check if circle is going off the scene or not
		if(circle.getCenterX() < getWidth() - circle.getRadius()) {
		circle.setCenterX(circle.getCenterX() + 100);
		}
		else {
			circle.setCenterX(circle.getCenterX());
		}
	}
	//Move ball left
	public void moveLeft() {
		//if statement to check if circle is going off the scene or not
		if(circle.getCenterX() > circle.getRadius()) {
		circle.setCenterX(circle.getCenterX() - 100);
		}
		else {
			circle.setCenterX(circle.getCenterX());
		}
		circle.setCenterY(circle.getCenterY());
	}
}