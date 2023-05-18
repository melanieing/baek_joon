import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * 1012. 유기농 양배추
 * 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력
 * 가로(m), 세로(n) : 1 <= m, n <= 50
 * 배추 개수(k) : 1 <= k <= 2500
 * 0 : 배추 X, 1 : 배추 O
 * 입력
 * 1
 * 5 3 6
 * 0 2
 * 1 2
 * 2 2
 * 3 2
 * 4 2
 * 4 0
 * 출력
 * 2
 */
public class OrganicCabbage1012 {

    static Queue<Point> q = new LinkedList<>(); // 탐색 큐
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] field; // 배추 밭
    static boolean[][] check; // 방문 배열

    static int nx, ny; // 현재 좌표
    static int m, n, k; // 가로, 세로, 배추 개수
    static int cnt; // 필요한 지렁이 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 갯수

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추 위치

            field = new int[n][m];
            check = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1; // 배추 위치 표시하기
            }

            cnt = 0; // 카운트 초기화

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!check[j][k] && field[j][k] == 1) { // 배추 자리인데 방문한 적 없다면
                        cnt++;
                        bfs(k, j);
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        q.offer(new Point(x, y));
        check[y][x] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < dx.length; i++) {
                nx = p.x + dx[i];
                ny = p.y + dy[i];

                if (isInRange() && !check[ny][nx] && field[ny][nx] == 1) { // 방문한적없는 배추라면
                    q.offer(new Point(nx, ny));
                    check[ny][nx] = true;
                }
            }
        }
    }

    static boolean isInRange() {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }
}
