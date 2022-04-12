package inOutOperator;

import java.util.Scanner;

public class MultipleThree2588 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		String c = Integer.toString(b);
		int[] mul = new int[3];
		int mulSum = 0;
		
		for (int i = 0; i < 3; i++) {
			mul[i] = a * Character.getNumericValue(c.charAt(2-i));
			if (i == 0) {
				System.out.println(mul[i]);
				mulSum += mul[i];
			} else if (i == 1) {
				System.out.println(mul[i]);
				mulSum += mul[i] * 10;
			} else if (i == 2) {
				System.out.println(mul[i]);
				mulSum += mul[i] * 100;
			}
		}
		System.out.println(mulSum);
		
		sc.close();
	}
}
