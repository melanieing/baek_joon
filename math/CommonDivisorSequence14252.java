package integer;

import java.util.Arrays;
import java.util.Scanner;

// 14252. 공약수열

public class CommonDivisorSequence14252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;

        Arrays.sort(arr); // 17, 42, 2184, 2200

        for (int i = 1; i < n; i++) {
            if (gcd(arr[i], arr[i-1]) != 1) {
                cnt += check(arr[i-1], arr[i]);
            }
        }

        System.out.println(cnt);

    }

    public static int gcd(int x, int y) {
        while (x % y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return y;
    }

    public static int check(int a, int b){
        for (int i = a + 1; i < b; i++) {
            if (gcd(a, i) == 1 && gcd(i, b) == 1 ) {
                return 1; // 하나만 추가하면 됨
            }
        }
        return 2; // 위에서 끝나지 않았다면 두 개를 추가해야 한다는 의미
    }
}
