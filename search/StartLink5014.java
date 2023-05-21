import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 5014. 스타트링크
 * 총 F층으로 이루어진 고층 건물, 스타트링크가 있는 곳은 G층, 강호가 지금 있는 곳은 S층
 * U버튼은 위로 U층을 가는 버튼, D버튼은 아래로 D층 (해당하는 층이 없을 때는, 엘리베이터는 움직이지 않는다)
 * 강호가 S층에서 G층으로 가기 위해 눌러야 하는 버튼의 수의 최솟값을 출력
 * 엘리베이터로 이동할 수 없을 때는 "use the stairs"를 출력
 * 입력
 * 10 1 10 2 1
 * 출력
 * 6
 */
public class StartLink5014 {
    static int f, s, g, u, d;
    static int[] building;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = sc.nextInt(); // 최대층
        s = sc.nextInt(); // 시작층
        g = sc.nextInt(); // 도착층
        u = sc.nextInt(); // 올라갈 수 있는 층 갯수
        d = sc.nextInt(); // 내려갈 수 있는 층 갯수

        building = new int[f+1]; // 층별 배열 만들기

        System.out.println(bfs());
    }

    static String bfs() {
        q.add(s); // 시작점 넣기
        building[s] = 1;

        while (!q.isEmpty()) {
            int cur = q.remove();

            if (cur == g) { // 현재 위치가 도착지라면
                return String.valueOf(building[cur] - 1);
            }
            if (cur + u <= f && building[cur + u] == 0) { // 올라갈 위치가 최대층보다 낮거나 같아야 함
                building[cur + u] = building[cur] + 1;
                q.add(cur + u);
            }
            if (cur - d >= 1 && building[cur - d] == 0) { // 내려갈 위치가 최하층보다 높거나 같아야 함
                building[cur - d] = building[cur] + 1;
                q.add(cur - d);
            }
        }
        return "use the stairs";

    }

}
