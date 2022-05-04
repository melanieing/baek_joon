package array1d;

import java.util.Scanner;

public class OX_8958 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] test = new String[n];
		
		for (int i = 0; i < n; i++) {
			test[i] = sc.next();
		}
		int[] corCnt = new int[n];
		int[] sum = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < test[i].length(); j++) {
				if (test[i].charAt(j) == 'O') {
					sum[i] += (++corCnt[i]);
					if (j != (test[i].length()-1) && test[i].charAt(j+1) == 'X') {
						corCnt[i] = 0;
						continue;
					}
				} else {
					continue;
				}
			}
		}
		
		for (int s : sum) {
			System.out.println(s);
		}

	}
}
