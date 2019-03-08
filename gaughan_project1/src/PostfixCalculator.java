import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostfixCalculator {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/postfix_test.txt"); // searches for the postfix_test.txt in the same directory
        Scanner fileScan = new Scanner(file); // fileScan loads the file

        while (fileScan.hasNextLine()) {
            String input = fileScan.nextLine();

            if (!input.equals("")) {
                System.out.println(postfixEvaluate(input));
            }
        }

    }

    private static int postfixEvaluate(String input) {
        Stack s = new Stack<>();
        Scanner lineScan = new Scanner(input);


        while (lineScan.hasNext()) {
            if (lineScan.hasNextInt()) {
                s.push(lineScan.nextInt());
            } else {
                int n1 = (int) s.pop();
                int n2 = (int) s.pop();
                String op = lineScan.next();

                switch (op) {
                    case "+":
                        s.push(n1 + n2);
                        break;
                    case "-":
                        s.push(n2 - n1);
                        break;
                    case "x":
                        s.push(n1 * n2);
                        break;
                    case "*":
                        s.push(n1 * n2);
                        break;
                    case "/":
                        s.push(n1 / n2);
                        break;
//                    case "p":
//                        s.push(Math.pow(n1, n2));
//                        break;
                }

            }
        }
        return (int) s.pop();
    }
}