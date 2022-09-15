import java.util.Scanner;

public class BreakEvenPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int fc = sc.nextInt(); // 고정비용
        int vc = sc.nextInt(); // 가변비용
        int price = sc.nextInt(); // 노트북 가격

        // 노트북 판매대수 : n
        // n * price = fc + (n * vc)
        // n = fc / (price - vc)
        // 이익이 발생하는 판매량 = fc / (price - vc) + 1 > 0이 되어야 함
        // 이익이 발생하지 않는 경우 -> 위의 값이 음수다
        // price - vc < 0
        // price와 vc가 같아도 붐모가 0이 되므로 안 됨
        // 최종 조건 : price <= vc

        if (price <= vc) {
            System.out.println("-1");
        } else {
            System.out.println((fc/(price-vc))+1);
        }

    }
}
