import java.util.Scanner;

public class Hive2292 {
    public static void main(String[] args) {
        // 1개 : 1 (1)
        // 2개 : 2,3,4,5,6,7 (6) 2*6 - 6
        // 3개 : 8,9,10,11,12,13,14,15,16,17,18,19 (12) 3*6 - 6
        // 4개 : (18) 4*6 - 6

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int room = 1;
        int range = 2;

        if (n == 1) {
            System.out.println(1);
        } else {
            while (range <= n) {
                range += room * 6;
                room++;
            }
            System.out.println(room);
        }


    }
}
