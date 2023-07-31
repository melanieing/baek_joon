import java.util.Scanner;
// 1978. 소수 찾기
public class PrimeNum1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int a : arr) {
            if (isPrime(a)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPrime(int a) {
        if (a == 1) {
            return false;
        }
        boolean result = true;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
