package inOutOperator;
// 1998년생인 내가 태국에서는 2541년생?!

import java.util.Scanner;

public class Bulgi18108 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int bulgi = sc.nextInt();
		sc.close();
		int seogi = bulgi - 543;
		
		System.out.println(seogi);

	}
}
