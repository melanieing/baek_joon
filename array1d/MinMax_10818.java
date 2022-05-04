package array1d;
import java.util.Arrays;
import java.util.Scanner;

public class MinMax_10818 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		System.out.printf("%d %d", array[0], array[array.length-1]);
		
	}
}
