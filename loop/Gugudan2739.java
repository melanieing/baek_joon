package loop;

import java.util.Scanner;

public class Gugudan2739 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();
		for (int i = n; i < n+1; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i*j);
			}
			System.out.println();
		}
	}
}
