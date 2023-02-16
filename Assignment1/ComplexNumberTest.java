public class ComplexNumberTest {
	public static void main(String [] args) {
		ComplexNumber num1 = new ComplexNumber(2.33, 4.567);
		ComplexNumber num2 = new ComplexNumber(3.289, -1.23);

		//Print complex numbers
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		System.out.println("\n##\n");

		//Add complex numbers
		System.out.println("num1 +(num2): " + num1.addComp(num2));
		System.out.println("\n##\n");
		System.out.println("num2 +(num1): " + num2.addComp(num1));
		System.out.println("\n##\n");

		//Subtract complex numbers
		System.out.println("num1 -(num2): " + num1.subtractComp(num2));
		System.out.println("\n##\n");
		System.out.println("num2 -(num1): " + num2.subtractComp(num1));
		System.out.println("\n##\n");

		//Multiply complex numbers
		System.out.println("num1 *(num2): " + num1.multiplyComp(num2));
		System.out.println("\n##\n");
		System.out.println("num2 *(num1): " + num2.multiplyComp(num1));
		System.out.println("\n##\n");

		//equal complex numbers
		System.out.println("Are numbers equal? (num1 eq(num2)): " + num1.equals(num2));
		System.out.println("\n##\n");

		//Random complex matrix
		for(int i=1; i<5; i++) {
			ComplexMatrix m1 = new ComplexMatrix(i+1, i);
			ComplexMatrix m2 = new ComplexMatrix(i+1, i);
			ComplexMatrix m3 = new ComplexMatrix(i, i+1);
			ComplexMatrix m4 = new ComplexMatrix(m3);
System.out.println(m1);
System.out.println(m2);
System.out.println(m3);
System.out.println(m4);
System.out.println();
			System.out.println("m1 +(m2): " + m1.CompAdd(m2));
			System.out.println("\n##\n");
			System.out.println("m1: " + m1);
			System.out.println("\n##\n");

			System.out.println("m2 -(m1): " + m2.CompSubtract(m1));
			System.out.println("\n##\n");
			System.out.println("m2: " + m2);
			System.out.println("\n##\n");

			System.out.println("m1 +(m3): " + m1.CompAdd(m3));
			System.out.println("\n##\n");
			System.out.println("m2: " + m2);
			System.out.println("\n##\n");

			System.out.println("m2 -(m3): " + m2.CompSubtract(m3));
			System.out.println("\n##\n");
			System.out.println("m2: " + m2);
			System.out.println("\n##\n");

			System.out.println("m4 +(m3): " + m4.CompAdd(m3));
			System.out.println("\n##\n");
			System.out.println("m4: " + m4);
			System.out.println("\n##\n");

			System.out.println("m4 -(m3): " + m4.CompSubtract(m3));
			System.out.println("\n##\n");
			System.out.println("m4: " + m4);
			System.out.println("\n##\n");
		}
	}
}
