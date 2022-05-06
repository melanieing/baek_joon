package solvedac;

import java.util.Scanner;

public class VerifyingNum_2475 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int verifyingNum = 0;
		
		for (int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			sum += num*num;
		}
		verifyingNum = sum % 10;
		System.out.println(verifyingNum);
		
	}

}
