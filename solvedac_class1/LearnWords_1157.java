package solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LearnWords_1157 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26]; // 영문자 개수만큼 배열 만들기
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				arr[str.charAt(i) - 97]++;
			} else {
				arr[str.charAt(i) - 65]++;
			}
		}
		
		int max = 0;
		char result = '?';
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = (char)(i+65);
			} else if (arr[i] == max) {
				result = '?';
			}
		}
		System.out.println(result);
	 }
}
