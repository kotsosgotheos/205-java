import java.util.Scanner;

public class LinearEquation2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Give alpha and beta: ");

        int alpha = input.nextInt();
        int beta = input.nextInt();

        if(alpha != 0) {
            double solution = -beta / (double)alpha;
            System.out.println("Solution to: `" + alpha + "x" + " + " + beta + " = 0` is x = " + solution);
        }
        else if(beta == 0) {
            System.out.println("Infinite Solutions");
        }
        else {
            System.out.println("No solution");
        }
    }
}
