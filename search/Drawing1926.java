package bfs;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 1926. 그림
 * 그림의 개수, 가장 넓은 그림의 넓이 구하기
 * 1 그림 : 1로 연결된 것 (가로, 세로만)
 * 그림의 넓이 : 그림에 포함된 1의 개수
 * 세로 길이 : 1 <= n <= 500, 가로 길이 : 1 <= m <= 500
 * 색칠된 부분(1), 색칠 안 된 부분(0)
 * 그림이 하나도 없는 경우 가장 넓은 그림의 넓이는 0
 * 입력
 * 6 5
 * 1 1 0 1 1
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 0 1 1 1
 * 0 0 1 1 1
 * 0 0 1 1 1
 * 출력
 * 4
 * 9
 */
public class Drawing1926 {

    static int n, m; // 세로, 가로
    static int[][] graph;
    static boolean[][] check; // 방문 체크 배열
    static int cnt = 0; // 각 그림 넓이
    static int[][] pos = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}}; // 하, 상, 우, 좌

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로
        m = sc.nextInt(); // 가로
        boolean noFlag = true; // 그림이 하나도 없는 경우 true
        List<Integer> answer = new ArrayList<>(); // 그림 리스트 (각각의 숫자는 그림넓이)

        graph = new int[n][m];
        check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt(); // 그래프 채우기
                if (graph[i][j] == 1) { // 그림이 있을 경우에
                    noFlag = false; // 플래그 false로 바꿔주기
                }
            }
        }

        if (noFlag) { // 그림이 없을 경우 바로 끝내기
            System.out.println("0");
            System.out.println("0");
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt = 0; // 그림넓이 초기화
                if (!check[i][j] && graph[i][j] == 1) { // 방문한 적 없고 그림일 경우
//                    dfs(i, j); // 깊이 우선 주변 탐색 진행하기
                    bfs(i, j); // 넓이 우선 주변 탐색 진행하기 (속도 더 빠름)
                    answer.add(cnt); // 그림 배열에 넓이 추가하기
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size()); // 그림의 개수
        System.out.println(answer.get(answer.size() - 1)); // 가장 넓은 그림의 넓이
    }

    static void dfs(int x, int y) {
        check[x][y] = true; // 방문 체크 해주기
        cnt++; // 그림 크기에 1더해주기

        for (int[] po : pos) {
            int nx = x + po[0];
            int ny = y + po[1];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !check[nx][ny] && graph[nx][ny] == 1) {
                // 범위 안에 있고, 방문한 적 없고, 그림이 있는 곳이면
                dfs(nx, ny);
            }
        }
    }

    static void bfs(int x, int y) {
        check[x][y] = true;
        cnt++;
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
                    // 범위에서 벗어나지 않고, 그림이고, 방문한적 없다면
                    cnt++; // 그림 넓이++
                    check[nx][ny] = true; // 방문 체크
                    q.add(new Point(nx, ny)); // 현재 좌표 큐에 넣어주기
                }
            }
        }
    }
}
