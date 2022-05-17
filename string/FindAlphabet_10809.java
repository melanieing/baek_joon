package string;

import java.util.Scanner;

public class FindAlphabet_10809 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		String word = sc.next();

		for (char i = 'a'; i <= 'z'; i++) {
			if (!word.contains(Character.toString(i))){
				System.out.print(-1 + " ");
				continue;
			}
			System.out.print(word.indexOf(i) + " ");
		}
	}
}
