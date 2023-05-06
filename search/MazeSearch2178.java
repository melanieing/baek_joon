package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2178. 미로 탐색
 * n * m 미로 : (1,1)에서 출발, (n,m)으로 이동 최소 칸 수 구하기
 * 이동 가능 칸(1), 이동 불가 칸(0)
 * 서로 인접한 칸으로만 이동 가능
 * 2 <= n, m <= 100
 * 입력
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 * 출력
 * 15
 */
public class MazeSearch2178 {

    static int n, m; // 세로, 가로
    static int[][] graph; // 인접행렬(미로)
    static boolean[][] check; // 방문 체크 배열
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}}; // 하, 상, 우, 좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로

        graph = new int[n][m]; // 인접행렬 생성
        check = new boolean[n][m]; // 방문 체크 배열 생성

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                graph[i][j] = Character.getNumericValue(ch);
            }
        }

        bfs(0, 0); // (0,0)에서 시작

        System.out.println(graph[n-1][m-1]); // 목적지까지의 거리 구하기
    }

    static void bfs(int x, int y) {
        check[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            int cx = p.x;
            int cy = p.y;

            for (int[] po : pos) {
                int nx = cx + po[0];
                int ny = cy + po[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == 1 && !check[nx][ny]) {
                    check[nx][ny] = true; // 방문 체크
                    graph[nx][ny] = graph[cx][cy] + 1; // 거리 누적하기
                    q.add(new Point(nx, ny)); // 큐에 넣어주기
                    
                    if (check[n-1][m-1]) { // 목적지에 방문하면 바로 끝내기
                        return;
                    }
                }
            }
        }
    }

}
