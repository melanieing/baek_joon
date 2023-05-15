import java.math.BigInteger;
import java.util.Scanner;

/**
 * 1914. 하노이 탑
 * n-1개의 원판을 A에서 B로 옮긴다. -> n번 원판을 A에서 C로 옮긴다. -> n-1개의 원판을 B에서 C로 옮긴다.
 * 원판이 n-1개일 때 옮길 수 있으면 원판이 n개일 때에도 옮길 수 있다.
 * n (1 ≤ n ≤ 100)
 * 입력
 * 3
 * 출력
 * 7
 * 1 3
 * 1 2
 * 3 2
 * 1 3
 * 2 1
 * 2 3
 * 1 3
 */
public class Hanoi1914 {

    static void dfs(int n, int start, int mid, int end) {
        // n개의 원판을 start에서 mid를 거쳐 end로 이동
        if (n == 1) { // 1개만 옮기면 될 때
            System.out.println(start + " " + end);
            return;
        }

        // 1. n-1개 원판을 A -> B
        dfs(n - 1, start, end, mid);

        // 2. A에 남아있는 1개를 C로 이동
        System.out.println(start + " " + end);

        // 3. n-1개의 원판을 B -> C
        dfs(n - 1, mid, start, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger bi = new BigInteger("2"); // n의 범위 때문에 사용
        BigInteger cnt = bi.pow(n).subtract(BigInteger.ONE);
        System.out.println(cnt); // 횟수 출력

        if (n <= 20) { // n이 20 이하일 때만 과정 출력
            dfs(n, 1, 2, 3);
        }

    }

}
