package loop;

import java.util.Scanner;
//    * 4 1
//   ** 3 2
//  *** 2 3
// **** 1 4
//***** 0 5
public class Star2_2439 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); 
		
		for (int i = 0; i < n; i++) {       // 0    1   2   3    4
			for (int j = i; j < n-1; j++) { // 0123 123 23  3 _
				System.out.print(" ");    
			}
			for (int j = 0; j <= i; j++) { //  0    01  012 0123 01234
				System.out.print("*");
			}
			System.out.println();
		}
		

		sc.close();
	}
}
