package inOutOperator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HelloWorld2557 {
	public static void main(String[] args) throws IOException {
		
		// 1. Using System Class
		// Ex1-1
		System.out.print("Hello World!");
		// Ex1-2
		System.out.printf("Hello World!");
		// Ex1-3
		System.out.printf("%s", "Hello World!"); // usually using variables
		// Ex1-4
		System.out.println("Hello World!"); // line-break at last
		
		// 2. Using BufferedWriter Class
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("Hello World!");
		bw.flush();
//		bw.close();
		
		// 3. Using StringBuffer Class
		StringBuffer sb = new StringBuffer();
		
		sb.append("Hello World!");
		System.out.print(sb);
		
		// 4. Using StringBuilder Class
		StringBuilder sd = new StringBuilder();
		
		sd.append("Hello World!");
		System.out.print(sd);
	
	}
}
