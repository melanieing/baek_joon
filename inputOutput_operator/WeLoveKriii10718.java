package inOutOperator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WeLoveKriii10718 {

	public static void main(String[] args) throws IOException {
		
		// 1. Using System Class
		// Ex1-1
		System.out.println("강한친구 대한육군");
		System.out.println("강한친구 대한육군");
		
		// Ex1-2
		System.out.print("강한친구 대한육군\n강한친구 대한육군");
		System.out.println(); // adiaphoron
		
		// Ex1-3
		String str = "강한친구 대한육군";
		System.out.printf("%s\n%s", str, str);
		System.out.println(); // adiaphoron
		
		// 2. Using BufferedWriter Class
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("강한친구 대한육군");
		bw.newLine(); // line-breaking
		bw.write("강한친구 대한육군");
		
		bw.flush();
//		bw.close();
		
		// 3. Using StringBuffer Class 
		StringBuffer sf = new StringBuffer();
		
		sf.append("강한친구 대한육군\n");
		sf.append("강한친구 대한육군");
		
		System.out.println(sf);
		
		// 4. Using StringBuilder Class
		StringBuilder sb = new StringBuilder();
		
		sb.append("강한친구 대한육군\n");
		sb.append("강한친구 대한육군");
		
		System.out.println(sb);

	}

}
