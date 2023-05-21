package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 2468. 안전 영역
 * 2차원 배열의 행/열 : 2 <= N <= 100
 * 각 높이 정보가 담긴 행렬 : 1 <= 높이 <= 100
 * 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력
 * 입력
 * 5
 * 6 8 2 6 2
 * 3 2 3 4 6
 * 6 7 3 3 2
 * 7 2 5 3 6
 * 8 9 5 2 7
 * 출력
 * 5
 */
public class SecureArea2468 {
    static int n; // 가로/세로 길이
    static int[][] field; // 모든 지역
    static boolean[][] check; // 방문 배열
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동좌표 배열
    static TreeSet<Integer> rainSet = new TreeSet<>(); // 강수량을 담을 셋

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 가로/세로 길이

        field = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                rainSet.add(field[i][j]); // 각 지역의 높이를 중복없이 담기
            }
        }
        int answer = Integer.MIN_VALUE / 2; // 정답(최대영역갯수)
        for (int rain : rainSet) { // 가능한 강수량마다 체크
            check = new boolean[n][n];
            int safeArea = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (field[i][j] >= rain && !check[i][j]) { // 강수량보다 높거나 같은 지역이고 방문한 적 없으면
                        dfs(i, j, rain);
                        safeArea++; // 안전지역이므로 하나 추가
                    }
                }
            }
            answer = Math.max(answer, safeArea); // 최대 안전지역의 갯수를 구하기
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int rain) {
        check[x][y] = true;

        for (int[] di : dis) {
            int nx = x + di[0];
            int ny = y + di[1];

            if (isInRange(nx, ny) && field[nx][ny] >= rain && !check[nx][ny]) { // 강수량보다 높고 방문한 적 없는 곳이면
                dfs(nx, ny, rain);
            }
        }
    }

    static boolean isInRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
