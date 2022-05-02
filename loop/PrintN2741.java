package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PrintN2741 {
	public static void main(String[] args) throws IOException {
		
		// Using Scanner
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int i = 1;
		while (i <= n) {
			System.out.println(i);
			i++;
		}
		
		// Using BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		for (int j = 1; j <= N; j++) {
			System.out.println(j);
		}
			
	
	}
}
