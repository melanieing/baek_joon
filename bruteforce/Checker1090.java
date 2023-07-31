package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
// 1090. 체커
public class Checker1090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] arrX = new int[n];
        int[] arrY = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] strArray = str.split(" ");
            int x = Integer.parseInt(strArray[0]);
            int y = Integer.parseInt(strArray[1]);
            arr[i][0] = x;
            arr[i][1] = y;
            arrX[i] = x;
            arrY[i] = y;
        }

        for (int x : arrX) {
            for (int y : arrY) {
                ArrayList<Integer> dist = new ArrayList<>();
                int d = 0;
                for (int a = 0; a < n; a++) {
                    d = Math.abs(arr[a][0] - x) + Math.abs(arr[a][1] - y);
                    dist.add(d);
                }
                Collections.sort(dist);
                int tmp = 0;

                for (int b = 0; b < dist.size(); b++) {
                    d = dist.get(b);
                    tmp += d;
                    if (answer[b] == -1) {
                        answer[b] = tmp;
                    } else {
                        answer[b] = Math.min(tmp, answer[b]);
                    }
                }
            }
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }


    }

}
