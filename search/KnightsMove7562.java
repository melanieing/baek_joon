import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7562. 나이트의 이동
 * 나이트가 최소 몇 번만에 이동하려는 칸으로 이동 가능할지 출력
 * 1. 체스판(정사각형)의 한 변의 길이 : I (4 ≤ l ≤ 300)
 * 2. 나이트가 현재 있는 칸
 * 3. 나이트가 이동하려고 하는 칸
 * 입력
 * 3
 * 8
 * 0 0
 * 7 0
 * 100
 * 0 0
 * 30 50
 * 10
 * 1 1
 * 1 1
 * 출력
 * 5
 * 28
 * 0
 */
public class KnightsMove7562 {

    static int n; // 가로/세로의 길이
    static Point cp, dp; // 현재 나이트의 좌표, 목적지 좌표
    static int[][] board; // 체스판
    static boolean[][] check; // 방문배열
    static Queue<Point> q = new LinkedList<>();
    static int[][] dis = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}}; // 말 이동가능 좌표
    static int nx, ny;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트케이스의 개수
        for (int i = 0; i < t; i++) {

            n = Integer.parseInt(br.readLine()); // 가로/세로의 길이

            // 체스판, 방문배열 생성
            board = new int[n][n];
            check = new boolean[n][n];

            // 현재 나이트 좌표
            st = new StringTokenizer(br.readLine());
            cp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            // 목적지 나이트 좌표
            st = new StringTokenizer(br.readLine());
            dp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();

            sb.append(board[dp.x][dp.y]).append('\n');
        }

        System.out.println(sb.toString());

    }

    static void bfs() {
        q.offer(cp);
        check[cp.x][cp.y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int cx = p.x;
            int cy = p.y;

            for (int[] di : dis) {
                nx = cx + di[0];
                ny = cy + di[1];

                if (isInRange() && !check[nx][ny]) {
                    q.offer(new Point(nx, ny));
                    board[nx][ny] = board[cx][cy] + 1; // 걸린 거리 구해서 넣기
                    check[nx][ny] = true;
                }
            }
        }
    }

    static boolean isInRange() {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
