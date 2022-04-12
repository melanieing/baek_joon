package condition;

import java.util.Scanner;

public class Alarm2884 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int H = sc.nextInt(), M = sc.nextInt();
		int HtoM = 0; // 600
		int totalMin = 0; // 610
		int alarmTime = 0;
		int alarmH = 0;
		int alarmM = 0;
		
		if (H >= 0 && H <= 23 && M >= 0 && M <= 59) {
			if (H == 0 && M < 45) {
				H = 24;
			}
			HtoM = H * 60; // 600
			totalMin = HtoM + M; // 610
			alarmTime = totalMin - 45;
			alarmH = alarmTime / 60;
			alarmM = alarmTime % 60;
		}
				
		System.out.println(alarmH + " " + alarmM);

	}
}
