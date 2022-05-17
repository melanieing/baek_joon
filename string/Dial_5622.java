package string;

import java.util.Scanner;

public class Dial_5622 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int time = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'W') {
				time += 10;
				continue;
			} else if (str.charAt(i) >= 'T') {
				time += 9;
				continue;
			} else if (str.charAt(i) >= 'P') {
				time += 8;
				continue;
			} else if (str.charAt(i) >= 'M') {
				time += 7;
				continue;
			} else if (str.charAt(i) >= 'J') {
				time += 6;
				continue;
			} else if (str.charAt(i) >= 'G') {
				time += 5;
				continue;
			} else if (str.charAt(i) >= 'D') {
				time += 4;
				continue;
			} else {
				time += 3;
			}
		}
		System.out.println(time);
	}
}
