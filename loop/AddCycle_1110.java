package loop;

import java.util.Scanner;

public class AddCycle_1110 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
				
		int N = sc.nextInt();
		int firstVal = N;

		while (true) {
			int result = solution(N);
			count++;
			if (result == firstVal) {
				break;
			} else {
				N = result;
			}
		}
		System.out.println(count);
		
	}
	
	public static int solution(int N) {
		String NtoString = Integer.toString(N);
		if (N < 10) {
			NtoString = "0" + Integer.toString(N);
		}
		int temp = Character.getNumericValue(NtoString.charAt(0)) + Character.getNumericValue(NtoString.charAt(1));
		String tempString = Integer.toString(temp);
		String newNum1 = NtoString.charAt(1) + tempString.substring(tempString.length()-1);
		return Integer.parseInt(newNum1);
	}
}
