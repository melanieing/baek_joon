import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7569. 토마토
 * 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익음
 * 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토
 * 토마토가 모두 익을 때까지 최소 며칠이 걸리는지 출력
 * 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력, 토마토가 모두 익지는 못하는 상황이면 -1을 출력
 * 상자의 가로(M), 세로(N) : 2 <= M, N <= 100
 * 상자의 수(H) : 1 <= H <= 100
 * 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 토마토가 없는 칸
 * 입력
 * 5 3 1
 * 0 -1 0 0 0
 * -1 -1 0 1 1
 * 0 0 0 1 1
 * 출력
 * -1
 */
public class Tomato7569 {
    static class Tomato { // 토마토 객체
        int z, y, x; // 가로, 세로, 높이

        Tomato(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
    static int m, n, h; // 가로, 세로, 높이
    static int[][][] field; // 판
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // x좌표 이동배열
    static int[] dy = {0, 0, -1, 1, 0, 0}; // y좌표 이동배열
    static int[] dz = {0, 0, 0, 0, -1, 1}; // z좌표 이동배열
    static int greenTomato = 0, days = 0; // 덜 익은 토마토 갯수, 다 익는 최소 일자
    static Queue<Tomato> redTomatoes = new LinkedList<>(); // 익은 토마토 큐
    static int nx, ny, nz; // 현재 x, y, z 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken()); // 가로
        n = Integer.parseInt(st.nextToken()); // 세로
        h = Integer.parseInt(st.nextToken()); // 높이
        field = new int[h][n][m]; // 그리드 생성

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < m; k++) {
                    field[i][j][k] = Integer.parseInt(st.nextToken());
                    if (field[i][j][k] == 0) { // 안 익은 토마토 개수 세주기
                        greenTomato++;
                    } else if (field[i][j][k] == 1) { // 토마토가 익었다면 익은 토마토 큐에 넣기
                        redTomatoes.add(new Tomato(i, j, k));
                    }
                }
            }
        }
        bfs();

        // 덜 익은 토마토가 없다면 = 다 익었다면 => 최소 일수 출력
        // 덜 익은 토마토가 있다면 = 다 익지 못했다면 => -1 출력
        System.out.println(greenTomato == 0 ? days : -1);

    }
    static void bfs() {
        while (greenTomato > 0 && !redTomatoes.isEmpty()) { // 덜 익은 게 있고, 익은 토마토도 있다면
            int size = redTomatoes.size();
            for (int i = 0; i < size; i++) {
                Tomato t = redTomatoes.remove();
                int x = t.x;
                int y = t.y;
                int z = t.z;

                for (int j = 0; j < dx.length; j++) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                    nz = z + dz[j];

                    if (isInRange() && field[nz][ny][nx] == 0) { // 안 익은 토마토가 있다면
                        greenTomato--; // 안 익은 토마토 개수에서 하나 빼주기
                        field[nz][ny][nx] = 1; // 익었다고 표시해주기
                        redTomatoes.add(new Tomato(nz, ny, nx)); // 익히기 + 큐에 추가
                    }
                }
            }
            days++; // 큐를 한 번 다 돌고 나면 하루가 지난 셈
        }
    }

    static boolean isInRange() {
        return nx >= 0 && ny >= 0 && nz >= 0 && nx < m && ny < n && nz < h;
    }
}
