import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GeneralBaseCounting {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/base_test.txt"); // searches for the file base_test.txt in the same directory
        Scanner fileScan = new Scanner(file); // fileScan loads the file

        while (fileScan.hasNextLine()) {
            String input = fileScan.nextLine();
            if (!input.equals("")) {
                countBase(input);
            }
            System.out.println(); //skips a line between expression outputs
        }
    }

    private static void countBase(String input) {
        Scanner lineScan = new Scanner(input); // lineScan loads the line from fileScan
        int b = Integer.parseInt(lineScan.next()); // b is base
        int n = Integer.parseInt(lineScan.next()); // n is listsize

        for (int i = 1; i < n + 1; i++) { // starts at 1, goes to n+1
            System.out.print(Integer.toString(i, b)); // toString(int a, int b) returns string representation of argument a in base b; toString(int a) returns String representing the parameter; obj.toString() returns String object representing Integer's value
            // rolls over in to letters if it runs out of numerical characters, then in to 1 and a letter
            if (i != n) {
                System.out.print(", ");
            }
        }
    }

}
