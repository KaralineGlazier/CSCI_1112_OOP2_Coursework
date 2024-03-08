/*
Author: Karaline Glazier
Date: 03/07/2024

Description: This program return the maximum element in an array
 */
public class Exercise19_05 {
  public static void main(String[] args) {
    Integer[] numbers = {1, 2, 3};
    System.out.println(max(numbers));
    
    String[] words = {"red", "green", "blue"};
    System.out.println(max(words));
    
    Circle[] circles = {new Circle(3), new Circle(2.9), new Circle(5.9)};
    System.out.println(max(circles));
  }
  
  static class Circle implements Comparable<Circle> {
    double radius;
    
    public Circle(double radius) {
      this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle c) {
      if (radius < c.radius) 
        return -1;
      else if (radius == c.radius)
        return 0;
      else
        return 1;
    }
    
    @Override
    public String toString() {
      return "Circle radius: " + radius;
    }
  }
  
  public static <E extends Comparable<E>> E max(E[] list) {
	  for (int i = 0; i < list.length; i++) {
			  if (list[i].compareTo(list[0]) > 0) {
				 list[0] = list[i];
			  }
	  }
	  return list[0];
  }
}