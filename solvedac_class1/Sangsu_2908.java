package solvedac;

import java.util.Scanner;

public class Sangsu_2908 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String atoStr = Integer.toString(a);
		String btoStr = Integer.toString(b);
		
		StringBuffer sba = new StringBuffer();
		for (int i = atoStr.length(); i  > 0; i--) {
			sba.append(atoStr.charAt(i-1));
		}
		
		StringBuffer sbb = new StringBuffer();
		for (int i = btoStr.length(); i  > 0; i--) {
			sbb.append(btoStr.charAt(i-1));
		}
		
		if (Integer.parseInt(sba.toString()) > Integer.parseInt(sbb.toString())) {
			System.out.println(sba);
		} else {
			System.out.println(sbb);
		}

	}
}
