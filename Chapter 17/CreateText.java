import java.io.*;
import java.util.*;

public class CreateText {
	public static void main(String[] args) throws FileNotFoundException {
		//create file 
		File file = new File("Exercise17_01.txt");
		//put integers in an array list
		ArrayList <String> listOfIntegers = new ArrayList<>();
		//check if file exists
		if(file.exists()){  //if file exists, append new data
			try(
					Scanner input = new Scanner(file);
					){
				while(input.hasNext()) {
					listOfIntegers.add(input.nextLine());
				}
			}
		}
			//add 100 random integers
			for (int i = 0; i < 100; i++) {
				listOfIntegers.add((int)(Math.random() * 500)+ " ");
			}
			try (
					PrintWriter output = new PrintWriter(file)
					){
				for (String list: listOfIntegers) {
					output.print(list);
				}
			}
	}
}