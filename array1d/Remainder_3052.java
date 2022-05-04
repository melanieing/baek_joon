package array1d;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Remainder_3052 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] inputs = new int[10];
		Integer[] remainders = new Integer[10];
		for (int i = 0; i < 10; i++) {
			inputs[i] = sc.nextInt();
			remainders[i] = inputs[i] % 42;
		}
		Set<Integer> results = new HashSet<>();
		Collections.addAll(results, remainders);
		System.out.println(results.size());

	}
}
