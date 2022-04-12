package inOutOperator;

import java.util.Scanner;

public class TheRest10430 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		
		int[] answer = new int[4];
		
		answer[0] = (a + b) % c;
		answer[1] = ((a % c) + (b % c)) % c;
		answer[2] = (a * b) % c;
		answer[3] = ((a % c) * (b % c)) % c;
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		sc.close();
	}
}
