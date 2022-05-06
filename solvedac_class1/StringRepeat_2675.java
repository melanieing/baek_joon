package solvedac;

import java.util.Scanner;

public class StringRepeat_2675 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		while (t >0) {
			int r1 = sc.nextInt();
			String s1 = sc.next();
			for (int i = 0; i < s1.length(); i++) {
				for (int j = 0; j < r1; j++) {
					sb.append(s1.charAt(i));					
				}
			}
			--t;
			sb.append("\n");
		}
		System.out.println(sb);

	}
}
