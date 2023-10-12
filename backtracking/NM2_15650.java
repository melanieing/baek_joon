package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 15650. N과 M (2)
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 (수열은 사전 순으로 증가하는 순서로 출력)
 * 고른 수열은 오름차순이어야 한다.
 */
public class NM2_15650 {
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

    /**
     * DFS 탐색 함수
     * @param at 현재 위치 = 어디서부터 시작하는지를 의미하는 변수
     * @param depth 재귀 함수 깊이
     */
    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= n; i++) { // at부터 시작해서 n까지
            arr[depth] = i;
            dfs(i +1, depth + 1);
        }
    }
}
