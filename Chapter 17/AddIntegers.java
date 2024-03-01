import java.io.*;
import java.util.*;

public class AddIntegers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			try(
					DataOutputStream output = 
					new DataOutputStream(new FileOutputStream("Exercise17_03.dat", true));
					){
				for(int i = 0; i < 100; i++) {
					output.writeInt((int)(Math.random() * 100));
				}
		}
		
			readFile();
		
	}
	
	
	public static void readFile() throws IOException {
		int sum = 0;
		try(
				DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat"));
				){
			while (true) {
				//reads integers from the file an unspecified amount of times and finds the sum of the integers
				sum += input.readInt();
			}
		}
			catch (EOFException ex) {
				System.out.println();
				System.out.println("The sum is " + sum);
			}			
	}
}
