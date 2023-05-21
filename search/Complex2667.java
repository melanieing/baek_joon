import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 2667. 단지번호붙이기
 * 1은 집이 있는 곳, 0은 집이 없는 곳
 * 연결되었다는 것 = 어떤 집의 상하좌우로 다른 집이 있는 경우 (대각선상 아님)
 * 총 단지수를 출력, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여
 * 지도의 크기 N(정사각형, 5 ≤ N ≤ 25)
 * 입력
 * 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 * 출력
 * 3
 * 7
 * 8
 * 9
 */
public class Complex2667 {

    static int n; // 가로/세로 길이
    static int[][] map; // 지도
    static boolean[][] check; // 방문배열
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동좌표 배열
    static int cnt; // 각 단지내의 집 수
    static ArrayList<Integer> answer = new ArrayList<>(); // 정답 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !check[i][j]) {
                    cnt = 0; // 단지 내 개수 초기화
                    dfs(i, j);
                    answer.add(cnt);
                }
            }
        }

        // 1. 단지 갯수 출력
        System.out.println(answer.size());

        // 2. 단지 내 집 갯수 오름차순 출력
        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }


    }

    static void dfs(int x, int y) {
        check[x][y] = true;
        cnt++;

        for (int[] di : dis) {
            int nx = x + di[0];
            int ny = y + di[1];
            
            // 방문한 적 없는 집이 있다면
            if (isInRange(nx, ny) && map[nx][ny] == 1 && !check[nx][ny]) {
                check[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean isInRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
