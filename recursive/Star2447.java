package recursive;

import java.util.Scanner;
/**
 * 2447. 별 찍기 - 10
 * 재귀적인 패턴으로 별 찍기
 * 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태
 * 입력 ( n = 3^k, 1 <= k < 8)
 * 27
 * 출력
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***   ***         ***   ***
 * * *   * *         * *   * *
 * ***   ***         ***   ***
 * *********         *********
 * * ** ** *         * ** ** *
 * *********         *********
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 * ***   ******   ******   ***
 * * *   * ** *   * ** *   * *
 * ***   ******   ******   ***
 * ***************************
 * * ** ** ** ** ** ** ** ** *
 * ***************************
 */
public class Star2447 {

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        arr = new char[n][n];
        
        // 재귀 실행
        star(0, 0, n, false);

        // 출력부
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    static void star(int x, int y, int n, boolean blank) {
        // 공백인 칸일 때
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' '; // 공백 찍기
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없는 블록일 때
        if (n == 1) {
            arr[x][y] = '*'; // 별 찍기
            return;
        }

        int size = n / 3; // 한 블록의 사이즈
        int cnt = 0; // 별 출력 누적
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                cnt++;
                star(i, j, size, cnt == 5); // 공백 칸 or 아닐 때 처리
            }
        }

    }
}
