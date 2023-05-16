package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1697. 숨바꼭질
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간 구하기(초)
 * N : 수빈 위치, K : 동생 위치 (0 ≤ N, K ≤ 100,000)
 * 걷기 : X -> X+1 OR X -> X-1
 * 순간이동 : X -> 2*X
 * 입력
 * 5 17
 * 출력
 * 4
 */
public class HideAndSeek1697 {

    static int n, k; // 수빈, 동생 위치
    static int[] check; // 방문배열
    static int[] dis = {-1, 1, 2}; // 이동좌표
    static Queue<Integer> q = new LinkedList<>(); // 탐색 큐

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        check = new int[100001];

        bfs(n);

    }

    static void bfs(int start) {
        q.offer(start);
        check[start] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) { // 종료 조건
                System.out.println(check[cur]-1);
                return;
            }

            for (int i = 0; i < dis.length; i++) {
                int next = i == 2 ? cur * dis[i] : cur + dis[i];
                if (next >= 0 && next <= 100000 && check[next] == 0) {
                    q.offer(next);
                    check[next] = check[cur] + 1;
                }
            }
        }

    }

}
