import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//prompt the user to enter an input file name for the encrypted file
		System.out.println("Enter an input file name for the encrypted file: ");
		File inputFile = new File(input.nextLine());
		//prompt the user to enter an output file name for the unencrypted version of the input file
		System.out.println("Enter an output file name for the decrypted version: ");
		File outputFile = new File(input.nextLine());
		
		try(
				BufferedInputStream in = new BufferedInputStream(
						new FileInputStream(inputFile));
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(outputFile));
				
				){
			int value;
			while((value = in.read()) != -1);{
			out.write(value - 5);
			}
		}
		
		
	}

}