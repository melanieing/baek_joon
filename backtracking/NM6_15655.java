package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 15655. N과 M (6)
 * N개의 자연수 중에서 M개를 중복 없이 고른 수열 (수열은 사전 순으로 증가하는 순서로 출력)
 * 고른 수열은 오름차순이어야 한다.
 */
public class NM6_15655 {

    static int n, m;
    static boolean[] visited;
    static int[] input;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        input = new int[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        dfs(0, 0);
        System.out.println(sb);

    }

    public static void dfs(int at, int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = input[i];
            dfs(i, depth + 1);
            visited[i] = false;
        }
    }
}
