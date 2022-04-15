package condition;

import java.util.Scanner;

public class OvenTimer2525 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(), m = sc.nextInt();
		int cookingTime = sc.nextInt();
		int hToM = 0;
		int time = 0;
		
		if (h >= 0 && h <= 23 && m >= 0 && m <= 59) {
			hToM = h * 60;
			time = hToM + m + cookingTime;
			h = time / 60;
			m = time % 60;
		}
		if (h >= 24) { // 만약 24시를 넘어간다면 0시로 변환
			h = h-24;
		} 
		System.out.println(h + " " + m);
		
		sc.close();
	}
}
