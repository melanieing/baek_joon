package inOutOperator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Div1008 {
	public static void main(String[] args) throws IOException {
		
		// 1. Using Scanner Class
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(), b = sc.nextInt();
		sc.close();
		double div1 = a / (double)b;
		
		System.out.println(div1);
		
		// 2. Using BufferedReader Class, split()
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str1 = br.readLine().split(" ");
		int c = Integer.parseInt(str1[0]);
		int d = Integer.parseInt(str1[1]);
		double div2 = c / (double)d;
		System.out.println(div2);
		
		// 3. Using BufferedReader, StringTokenizer Classes
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		double div3 = e / (double)f;
		System.out.println(div3);

	}
}
