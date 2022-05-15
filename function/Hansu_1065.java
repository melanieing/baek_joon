package function;

import java.util.Scanner;

public class Hansu_1065 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt();
		int cnt = 0;
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		for (a = 1; a <= 9; a++) {
			for (b = 0; b <= 9; b++) {
				for (c = 0; c<= 9; c++) {
					if ((100*a + 10*b + c) <= max) {
						if (a-b == b-c) {
							cnt++;		
						}
					}
				}
			}
		}
		
		if (max <= 99) {
			System.out.println(max);
		} else {
			System.out.println(cnt + 99);
		}

	}
}
