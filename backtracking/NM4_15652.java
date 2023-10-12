package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 15652. N과 M (4)
 * 1부터 N까지 자연수 중에서 M개를 고른 수열 (사전 순으로 증가하는 순서로 출력)
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 */
public class NM4_15652 {

    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }

    }
}
