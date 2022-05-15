package function;

public class Sum_15596 {
	
	public static long sum(int[] a) {
		long result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5};
		
		System.out.println(sum(a));

	}
}
