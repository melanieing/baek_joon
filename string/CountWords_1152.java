package string;

import java.util.Scanner;

public class CountWords_1152 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((i != 0) && (str.charAt(i) == ' ') && (i != (str.length()-1))) {
				++cnt;
			}
		}
		System.out.println(cnt+1);
	}
}
