package array1d;

import java.util.Arrays;
import java.util.Scanner;

public class HowMany_2577 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String mul = Integer.toString(a*b*c);
		String[] mulArray = mul.split("");
		int[] numbers = new int[10];
		Arrays.fill(numbers, 0);
		
		for (int i = 0; i < mulArray.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (Integer.parseInt(mulArray[i]) == j) {
					numbers[j]++;
				}
			}
		}
		for (int number : numbers) {
			System.out.println(number);
		}


	}
}
