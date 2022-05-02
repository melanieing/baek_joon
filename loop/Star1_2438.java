package loop;

import java.util.Scanner;

public class Star1_2438 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) { 	    //1    2   3    4    5
			for (int j = 1; j <= n-i; j++) {//1234 123 12   1    0
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");	//1    12   123 1234 12345
			}
			System.out.println();
		}

		sc.close();
	}
}
