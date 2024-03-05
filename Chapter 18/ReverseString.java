import java.util.Scanner;
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a word or string to be reversed: ");
		String value = input.nextLine();
		System.out.print("The string reversed is ");
		reverseDisplay(value);
	}
	
	public static void reverseDisplay(String value) {
		String result = "";
		result = value.charAt(0) + result;
		if (value.length() <= 1) {
			System.out.println(result);
		}
		else {
			result = value.charAt(value.length() - 1) + result;
			reverseDisplay(value);
			
		}
	}
}