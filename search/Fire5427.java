import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 5427. 불
 * 수 있는 경우, 가장 빠른 탈출시간 출력 (불가능하면 "IMPOSSIBLE" 출력)
 * 지훈이와 불은 매 분마다 한 칸씩 수평 또는 수직으로(비스듬하게 이동하지 않는다) 동시에 이동
 * w은 미로 행의 개수, h는 열의 개수 (1 ≤ w, h ≤ 1000)
 * '.': 빈 공간
 * '#': 벽
 * '@': 상근이의 시작 위치
 * '*': 불
 * 입력
 * 5
 * 4 3
 * ####
 * #*@.
 * ####
 * 7 6
 * ###.###
 * #*#.#*#
 * #.....#
 * #.....#
 * #..@..#
 * #######
 * 7 4
 * ###.###
 * #....*#
 * #@....#
 * .######
 * 5 5
 * .....
 * .***.
 * .*@*.
 * .***.
 * .....
 * 3 3
 * ###
 * #@#
 * ###
 * 출력
 * 3
 */
public class Fire5427 {

    static int w, h, answer; // 가로, 세로, 정답(최소일수)
    static char[][] maze; // 미로
    static boolean[][] check; // 방문배열
    static Queue<Point> fq; // 불 탐색 큐
    static Queue<Point> pq; // 상근이 탐색 큐
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int ts = Integer.parseInt(br.readLine());
        for (int t = 0; t < ts; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken()); // 가로 입력받기
            h = Integer.parseInt(st.nextToken()); // 세로 입력받기

            maze = new char[h][w];
            check = new boolean[h][w];

            fq = new LinkedList<>();
            pq = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    maze[i][j] = str.charAt(j);

                    if (maze[i][j] == '@') { // 상근이 시작 위치 저장
                        pq.offer(new Point(i, j, 0));
                    } else if (maze[i][j] == '*') { // 불 시작 위치 저장
                        fq.offer(new Point(i, j, 0));
                    }
                }
            }
            answer = 0; // 최소일수 초기화

            bfs();

            if (answer == 0) {
                sb.append("IMPOSSIBLE").append('\n');
            } else {
                sb.append(answer).append('\n');
            }
        }
        System.out.println(sb);
    }

    /* 범위 안에 있는지 확인 (w, h 바뀌지 않도록 조심) */
    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < h && y < w;
    }

    static void bfs() {

        while (!pq.isEmpty()) {

            // 불이 가는 길 탐색
            int size = fq.size();
            for (int i = 0; i < size; i++) {
                Point p = fq.remove();
                for (int[] di : dis) {
                    int nx = p.x + di[0];
                    int ny = p.y + di[1];

                    if (isInRange(nx, ny) && (maze[nx][ny] == '.' || maze[nx][ny] == '@')) { // 범위 안에 있고 + 벽/상근일 경우 갈 수 있음
                        maze[nx][ny] = '*'; // 불 표시
                        fq.offer(new Point(nx, ny, 0));
                    }

                }
            }

            // 상근이가 가는 길 탐색
            size = pq.size();
            for (int i = 0; i < size; i++) {
                Point p = pq.remove();
                for (int[] di : dis) {
                    int nx = p.x + di[0];
                    int ny = p.y + di[1];

                    if (!isInRange(nx, ny)) { // 범위 안에 없다면 끝내는데 시간은 더해줘야 함
                        answer = p.cnt + 1;
                        return;
                    }

                    if (maze[nx][ny] == '.') { // 빈 공간이라면 갈 수 있음
                        maze[nx][ny] = '@';
                        pq.offer(new Point(nx, ny, p.cnt + 1));
                    }

                }
            }

        }
    }
    static class Point { // x좌표, y좌표, 카운트 값
        int x, y, cnt;

        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
}
