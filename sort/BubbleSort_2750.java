package bronze;

import java.util.Scanner;

public class BubbleSort_2750 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i = 0; i < n-1; i++) { // 0, 1, 2, 3
			for (int j = 0; j < n-1-i; j++) { // 0123, 012, 01, 0
				if (arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		for (int a : arr) {
			System.out.println(a);
		}
		
	}
}
