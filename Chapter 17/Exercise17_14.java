import java.util.Scanner;
import java.io.*;

public class Exercise17_14  {
	public static void main(String[] args) throws Exception {
	Scanner input = new Scanner(System.in);
	//Prompts user to enter an input file name
	System.out.println("Enter an input file name: ");
	File inputFile = new File(input.nextLine());
	//prompts user to enter an output file name
	System.out.println("Enter an output file name: ");
	File outputFile = new File(input.nextLine());
	//create random access files for input and output
	try (
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
			){
		//create value
		int value;
		//go to the beginning of the file
		while((value = in.read()) != -1) {
			//add 5 to every byte in the file 
			out.write(value + 5);
		}
		
	}
	
	}
	
}