package loop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QuickSum15552 {
	public static void main(String[] args) throws IOException {
		// StringTokenizer 사용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int testNum = Integer.parseInt(br.readLine());
//		StringTokenizer st;
//		
//		for (int i = 0; i < testNum; i++) {
//			st = new StringTokenizer(br.readLine());
//			bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
//		}
//		br.close();
//		
//		bw.flush();
//		bw.close();
		
		// StringBuilder 사용
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int testNum = Integer.parseInt(br.readLine());
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i = 0; i < testNum; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
//		}
//		br.close();
//		
//		System.out.println(sb);
		
		// String.indexOf(), String.substring() 메서드 사용하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testNum; i++) {
			String str = br.readLine();
			int target = str.indexOf(" "); // (맨 앞 ~ 공백 전) + (공백 다음 ~)
			int result = Integer.parseInt(str.substring(0, target)) + Integer.parseInt(str.substring(target + 1));
			sb.append(result+"\n");
		}
		br.close();
		System.out.println(sb);
	}
}
