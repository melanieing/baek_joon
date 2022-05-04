package array1d;

import java.util.Scanner;

public class AverageOver_4344 {	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		double[] answers = new double[c];
		
		for (int i = 0; i < c; i++) {
			int student = sc.nextInt();
			int[] scores = new int[student];
			int sum = 0;
			double avg = 0.0;
			for (int j = 0; j < scores.length; j++) {
				scores[j] = sc.nextInt();
				sum += scores[j];
			}
			avg = sum/(double)student;
			int cnt = 0;
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] > avg) {
					cnt++;
				}
			}
			double ratio = cnt/(double)(scores.length) * 100;
			answers[i] = ratio;
		}
		
		for (double answer : answers) {
			System.out.printf("%.3f%%\n", answer);			
		}
	}
}
