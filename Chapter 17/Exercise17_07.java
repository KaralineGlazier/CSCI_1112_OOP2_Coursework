import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
     
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }
    public static void outputData() throws ClassNotFoundException, IOException   {
    	double amount = 0;
    	try (
    		ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
    		){
    	while (true) { //runs while there are loan objects
    		Loan loan = (Loan)(input.readObject());
    		amount += loan.getLoanAmount();
    	}
    }
    	catch (EOFException ex) {
    		System.out.println("The total amount is " + amount);
    	}
    }
}
 