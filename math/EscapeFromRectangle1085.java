import java.util.Arrays;
import java.util.Scanner;

public class EscapeFromRectangle1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(), y = sc.nextInt();
        int w = sc.nextInt(), h = sc.nextInt();

        int[] directions = new int[4];

        directions[0] = x - 0; // 왼쪽
        directions[1] = w - x; // 오른쪽
        directions[2] = h - y; // 위
        directions[3] = y - 0; // 아래

        System.out.println(Arrays.stream(directions).min().getAsInt());

    }
}
