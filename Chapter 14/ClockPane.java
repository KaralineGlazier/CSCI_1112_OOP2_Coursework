import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class ClockPane extends Pane {
	private int hour;
	private int minute;
	private int second;
	private boolean hourHandVisible;
	private boolean minuteHandVisible;
	private boolean secondHandVisible;
	
	public ClockPane() {
		setCurrentTime();
	}
	
	public ClockPane(int hour, int minute, int second, boolean hourHandVisible, boolean minuteHandVisible, boolean secondHandVisible) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.hourHandVisible = hourHandVisible;
		this.minuteHandVisible = minuteHandVisible;
		this.secondHandVisible = secondHandVisible;
	}
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}
	
	public int getMinute()  {
		return minute;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}
	
	public int getSecond() {
		return second;
	}
	
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}
	
	public boolean getHourHandVisible() {
		return hourHandVisible;
	}
	
	public void setHourHandVisible(boolean hourHandVisible) {
		this.hourHandVisible = hourHandVisible;
		paintClock();
	}
	
	public boolean getMinuteHandVisible() {
		return minuteHandVisible;
	}
	
	public void setMinuteHandVisible(boolean minuteHandVisible) {
		this.minuteHandVisible = minuteHandVisible;
		paintClock();
	}
	
	public boolean getSecondHandVisible() {
		return secondHandVisible;
	}
	
	public void setSecondHandVisible(boolean secondHandVisible) {
		this.secondHandVisible = secondHandVisible;
		paintClock();
	}
	
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		
		paintClock();
	}
	
	private void paintClock() {
		double clockRadius = 
				Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		
		getChildren().clear();
		getChildren().add(circle);
		getChildren().add(t1);
		getChildren().add(t2);
		getChildren().add(t3);
		getChildren().add(t4);
		
		//Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * 				
				Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * 
				Math.cos(second * (2 * Math.PI / 60));
			//May end up putting if statement here instead if there's problem
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);
		
		if (secondHandVisible == true) {
			getChildren().add(sLine);
		}
		
		//Draw minute hand if visible
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * 
				Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * 
				Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);
		
		if (minuteHandVisible == true) {
			getChildren().add(mLine);
		}
		
		//Draw hour hand if visible
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * 
				Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * 
				Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		
		if (hourHandVisible == true) {
			getChildren().add(hLine);
		}
		
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paintClock();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paintClock();
	}
}