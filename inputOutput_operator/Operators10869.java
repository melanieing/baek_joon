package inOutOperator;

import java.util.Scanner;

public class Operators10869 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		sc.close();
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		int quo = a / b;
		int rem = a % b;
		
		System.out.printf("%d\n%d\n%d\n%d\n%d", sum, sub, mul, quo, rem);

	}

}
