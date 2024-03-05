import java.util.Scanner;

public class Recursion_Fundamental {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.println("Find the greatest common diviser between 2 integers");
	System.out.println("Enter an integer: ");
	int num1 = input.nextInt();
	System.out.println("Enter another integer: ");
	int num2 = input.nextInt();
	System.out.println("The greatest common diviser between the two numbers is " + findGCD(num1, num2));
	}
	public static int findGCD(int m, int n) {
		
		if (m % n == 0) {
			return n;
		}
		else {
			return findGCD(n, m % n);
		}
		
	}
}
