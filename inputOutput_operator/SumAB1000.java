package inOutOperator;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumAB1000 {
	public static void main(String[] args) throws IOException {
		
		// 1. Using Scanner Class
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		sc.close();
		
		int sum = a + b;
		
		System.out.println(sum);
		
		
		// 2. Using BufferedReader Class, split()
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] str = br.readLine().split(" ");
//		int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
//		
//		System.out.println(a + b);
		
		// 3. Using BufferedReader, StringTokenizer Classes
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str, " ");
//		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
//		
//		System.out.println(a + b);
		
	}
}
