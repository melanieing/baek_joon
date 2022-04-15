package loop;

import java.util.Scanner;

public class V3Sum10950 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int[] nums = new int[testCase*2];
		int[] sums = new int[testCase];
		
		for (int i = 0; i < testCase*2; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < testCase; i++) {
			sums[i] = nums[i*2] + nums[i*2+1];
			System.out.println(sums[i]);
		}
		sc.close();
	}
}
