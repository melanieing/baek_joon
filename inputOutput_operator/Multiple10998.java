package inOutOperator;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple10998 {

	public static void main(String[] args) throws IOException {
		
		// 1. Using Scanner Class
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
//		sc.close();
		int mul1 = a * b;
		
		System.out.println(mul1);
		
		// 2. Using BufferedReader Class, split()
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		int c = Integer.parseInt(str1[0]);
		int d = Integer.parseInt(str1[1]);
		int mul2 = c * d;
		System.out.println(mul2);
		
		// 3. Using BufferedReader, StringTokenizer Classes
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int mul3 = e * f;
		System.out.println(mul3);
	}

}
