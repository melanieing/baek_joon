package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 7576. 토마토
 * n * m 창고 : 모든 토마토가 익는 최소 일수 구하기
 * 2 <= m, n <= 1000
 * 익은 토마토의 인접한 곳(상하좌우)에 있으면 익음
 * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토 없는 칸
 * 입력
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 * 출력
 * 8
 */
public class Tomato7576 {

    static int day = 0; // 걸리는 최소일수
    static int n, m; // 세로, 가로
    static int[][] graph; // 인접행렬
    static Queue<Tomato> q = new LinkedList<>(); // 큐
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}}; // 하, 상, 우, 좌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 1) { // 익은 토마토라면 탐색할 큐에 넣기
                    q.offer(new Tomato(i, j, 0));
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) { // 안 익은 토마토가 하나라도 있다면
                    day = -1;
                    break;
                }
            }
        }
        if (day != -1) { // 다 익었다면 최소일수 출력
            System.out.println(day - 1);
        } else { // 안 익은 게 있다면 -1 출력
            System.out.println(day);
        }

    }

    static void bfs() {

        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            int cx = tomato.x;
            int cy = tomato.y;
            int days = tomato.day + 1; // 토마토 생성되는데 걸린 일수

            for (int[] po : pos) {
                int nx = cx + po[0];
                int ny = cy + po[1];
                if (nx >= 0 && nx < n && ny >= 0 & ny < m) {
                    day = days; // 일 수 증가
                    if (graph[nx][ny] == 0) { // 안 익은 토마토라면
                        graph[nx][ny] = 1; // 익었다고 표시하기
                        q.add(new Tomato(nx, ny, days)); // 탐색 큐에 넣기
                    }
                }
            }
        }

    }

    static class Tomato {
        int x, y;
        int day;

        Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
