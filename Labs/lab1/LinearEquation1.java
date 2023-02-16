import java.util.Scanner;

public class LinearEquation1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Give alpha and beta: ");
        
        int alpha = input.nextInt();
        int beta = input.nextInt();
        double solution = -beta / (double)alpha;
        
        System.out.println("Solution to: `" + alpha + "x" + " + " + beta + " = 0` is x = " + solution);
    }
}
