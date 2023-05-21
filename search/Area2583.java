import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 2583. 영역 구하기
 * 분리되어 나누어지는 영역의 개수, 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력
 * 1 <= m,n,k <= 100 (세로, 가로, 직사각형 개수)
 * 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)
 * 입력
 * 5 7 3
 * 0 2 4 4
 * 1 1 2 5
 * 4 0 6 2
 * 출력
 * 3
 * 1 7 13
 */
public class Area2583 {
    static int m, n, k; // 세로, 가로, 직사각형 개수
    static int[][] board; // 영역
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동좌표 배열
    static int cnt = 0; // 영역 넓이 저장할 변수
    static ArrayList<Integer> answer = new ArrayList<>(); // 정답 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken()); // 세로
        n = Integer.parseInt(st.nextToken()); // 가로
        k = Integer.parseInt(st.nextToken()); // 직사각형 개수

        board = new int[m][n]; // 영역 판 생성

        for (int i = 0; i < k; i++) { // 각각 입력 받기
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    board[j][k] = 1; // 직사각형 표시
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    cnt = 0; // 영역넓이 초기화
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        // 1. 영역 갯수 출력
        System.out.println(answer.size());

        // 2. 영역 넓이 오름차순 출력
        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }

    }

    static void dfs(int x, int y) {
        board[x][y] = 1;
        cnt++;

        for (int[] di : dis) {
            int nx = x + di[0];
            int ny = y + di[1];

            if (isInRange(nx, ny) && board[nx][ny] == 0) { // 범위 안에 있고 직사각형이 아닐 경우
                dfs(nx, ny);
            }
        }
    }

    static boolean isInRange(int x, int y) { // 범위 안에 있는지 확인
        return x >= 0 && y >= 0 && x < m && y < n; // m, n 바뀌지 않도록 주의!!!
    }
}
