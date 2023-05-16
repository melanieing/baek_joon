package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 4179. 불!
 * 지훈이가 미로를 탈출할 수 있는 경우, 가장 빠른 탈출시간 출력 (불가능하면 "IMPOSSIBLE" 출력)
 * 지훈이와 불은 매 분마다 한 칸씩 수평 또는 수직으로(비스듬하게 이동하지 않는다) 동시에 이동
 * R은 미로 행의 개수, C는 열의 개수 (1 ≤ R, C ≤ 1000)
 * #: 벽
 * .: 지나갈 수 있는 공간
 * J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
 * F: 불이 난 공간
 * 입력
 * 4 4
 * ####
 * #JF#
 * #..#
 * #..#
 * 출력
 * 3
 */
public class Fire4179 {

    static int r, c; // 세로, 가로
    static char[][] maze; // 미로
    static boolean[][] check; // 방문배열
    static Queue<Point> q = new LinkedList<>(); // 탐색 큐
    static Point start; // 처음 위치
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동거리

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]); // 행
        c = Integer.parseInt(input[1]); // 열

        maze = new char[r][c]; // 미로 생성
        check = new boolean[r][c]; // 방문배열 생성

        for (int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                maze[i][j] = input[j].charAt(0); // 입력받아서 미로에 넣기

                if (maze[i][j] == 'J') { // 지훈이가 있는 자리
                    if (isEdge(i, j)) { // 바로 가장자리일 경우
                        System.out.println(1); // 1번만 이동하면 바로 끝남
                        return;
                    }

                    maze[i][j] = '.';
                    start = new Point(i, j, 0, 0); // 시작점에 지훈이 위치를 넣기
                } else if (maze[i][j] == 'F') { // 불이 있는 자리
                    q.add(new Point(i, j, 1, 0)); // 불 먼저 넣고 탐색
                }
            }
        }

        bfs();

    }

    private static boolean isEdge(int x, int y) { // 미로의 가장자리인지 판별
        for (int[] di : dis) {
            int nx = x + di[0];
            int ny = y + di[1];

            if (!isRange(nx, ny)) { // 가장자리이면 true 반환
                return true;
            }
        }
        return false; // 가장자리가 아니면 false 반환
    }

    private static boolean isRange(int x, int y) { // 미로의 범위를 벗어나는지 판별
        return x >= 0 && y >= 0 && x < r && y < c; // 벗어나지 않으면 true, 벗어나면 false 반환
    }

    static void bfs() { //불과 지훈이를 종료조건일때까지 이동시키기
        q.offer(start); // 지훈이 위치를 큐에 넣기
        check[start.x][start.y] = true; // 방문 표시하기

        while (!q.isEmpty()) {
            Point p = q.poll(); // 큐에서 하나 뽑기
            int cx = p.x;
            int cy = p.y;
            int cnt = p.cnt;

            if (isEdge(cx, cy) && p.type == 0) { // 종료 조건(지훈이가 가장자리에 닿았을 때)
                System.out.println(cnt + 1);
                return;
            }

            for (int[] di : dis) { // 4가지 방향으로 이동시키기
                int nx = cx + di[0];
                int ny = cy + di[1];

                if (!isRange(nx, ny) || maze[nx][ny] == '#' || maze[nx][ny] == 'F') { // 범위를 벗어나거나 벽이거나 불이면 넘어가기
                    continue;
                }

                if (p.type == 0 && !check[nx][ny]) { // 지훈이가 방문하지 않은 곳을 방문한다면
                    q.add(new Point(nx, ny, p.type, cnt + 1)); // 큐에 다시 넣기
                    check[nx][ny] = true; // 방문표시
                } else if (p.type == 1) { // 불이라면
                    maze[nx][ny] = 'F'; // 불이 지나갔다는 표시해주기
                    q.add(new Point(nx, ny, p.type, cnt + 1)); // 큐에 다시 넣기
                }
            }
        }
        System.out.println("IMPOSSIBLE"); // 불가능하다면 출력
    }

    static class Point { // x좌표, y좌표, 좌표 종류(0 : 지훈, 1 : 불), 카운트 값
        int x, y, type, cnt;

        public Point(int x, int y, int type, int cnt) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.cnt = cnt;
        }
    }
}
