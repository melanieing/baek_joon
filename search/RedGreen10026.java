import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 10026. 적록색약
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림
 * 한 구역은 같은 색으로 이루어져 있음
 * 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램
 * 1 ≤ N ≤ 100
 * 입력
 * 5
 * RRRBB
 * GGBBB
 * BBBRR
 * BBRRR
 * RRRRR
 * 출력
 * 4 3
 */
public class RedGreen10026 {

    static char[][] board; // 그리드
    static boolean[][] checkForYes, checkForNo; // 적록색약인 사람, 아닌 사람의 방문배열
    static int[][] dis = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 이동좌표 배열
    static int n, nx, ny; // 가로/세로 길이, 현재 x좌표, 현재 y좌표
    static int cntForYes = 0, cntForNo = 0; // 적록색약인 사람이 보는 구역 수, 아닌 사람이 보는 구역 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 가로/세로 길이 입력받기
        n = Integer.parseInt(br.readLine());
        // 그리드 값 입력받기
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        // 방문배열 초기화
        checkForYes = new boolean[n][n];
        checkForNo = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j =0; j < n; j++) {
                if (!checkForYes[i][j]) {
                    dfsForYes(i, j);
                    cntForYes++;
                }
                if (!checkForNo[i][j]) {
                    dfsForNo(i, j);
                    cntForNo++;
                }
            }
        }

        System.out.println(cntForNo + " " + cntForYes);

    }

    private static void dfsForNo(int x, int y) {
        checkForNo[x][y] = true;
        for (int[] di : dis) {
            nx = x + di[0];
            ny = y + di[1];
            if (isInRange() && !checkForNo[nx][ny] && board[nx][ny] == board[x][y]) {
                checkForNo[nx][ny] = true;
                dfsForNo(nx, ny);
            }
        }
    }

    private static void dfsForYes(int x, int y) {
        checkForYes[x][y] = true;
        for (int[] di : dis) {
            nx = x + di[0];
            ny = y + di[1];
            if (isInRange() && !checkForYes[nx][ny] &&
                    ((board[nx][ny] == board[x][y]) || (board[x][y] != 'B' && board[nx][ny] != 'B'))) {
                checkForYes[nx][ny] = true;
                dfsForYes(nx, ny);
            }
        }
    }


    static boolean isInRange() {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }
}
