/*
Author: Karaline Glazier
Date: 03/08/2024

Description: This program sorts a list from the lowest element in the list, to the highest element in the list. 
*/
import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  public static <E extends Comparable <E>> void sort(ArrayList<E> list) {
	  E min; //smallest number 
	  int smallestIndex; //index that has the smallest number
	  for (int i= 0; i < list.size() - 1; i++) { 
		  min = list.get(i); // minimum number is going to be at the top of the list
		  smallestIndex = i; //top of the list is the smallest number
		  for (int j = i + 1; j < list.size(); j++) { 
			  //if the current smallest number is greater than the next number in the list, that number becomes the new smallest number.
			  if (min.compareTo(list.get(j)) > 0) {
				  min = list.get(j);
				  smallestIndex = j;
			  }
		  }
		  if (smallestIndex != i) { //if index i is not the smallest number, set i to be the smallest number
			  list.set(smallestIndex, list.get(i));
			  list.set(i, min);
		  }
	  }
  }
}
