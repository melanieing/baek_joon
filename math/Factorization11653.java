package integer;

import java.util.Scanner;
// 11653. 소인수분해
public class Factorization11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int number = 2;

        while (n != 1) {
            if (n % number == 0) {
                System.out.println(number);
                n = n / number;
                number = 2;
            } else {
                number++;
            }
        }
    }
}
