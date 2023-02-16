import java.util.Scanner;

public class LinearEquation3 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to solve a linear equation? (yes/no): ");
		String answer = input.next();
		
        while(answer.equals("yes")) {
            System.out.print("Give alpha and beta: ");
			int alpha = input.nextInt();
			int beta = input.nextInt();
			if(alpha != 0) {
				double solution = -beta / (double)alpha;
				System.out.println("Solution to `" + alpha + "x" + " + " + beta + " = 0` is x = "+solution);
			}
            else if(beta == 0) {
				System.out.println("Infinite Solutions");
			}
            else {
				System.out.println("No solution");
			}
			System.out.print("Do you want to solve a linear equation? (yes/no): ");
			answer = input.next();
		}
	}
}
