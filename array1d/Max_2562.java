package array1d;
import java.util.Arrays;
import java.util.Scanner;

public class Max_2562 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = 9;
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		int[] array2 = Arrays.copyOf(array, n);
		Arrays.sort(array2);
		
		int pos = 0;
		for (int i = 0; i < n; i++) {
			if (array2[n-1] == array[i]) {
				pos = i+1;
				break;
			}
		}
		System.out.printf("%d\n%d", array2[n-1], pos);
		
	}
}
