package function;

import java.util.ArrayList;

public class SelfNum_4673 {
    public static void main(String[] args) {

        // 10000보다 작은 d(n)을 모두 ArrayList에 담기
        ArrayList<Integer> ds = new ArrayList<>();

        int n  = 1;
        while (true) {
            if (n > 10000) {    //이렇게 바꿔서 제출해봐봐
                break;
            }
            ds.add(d(n));
            ++n;
        }
        // ArrayList를 배열로 옮기기
        int[] array = new int[ds.size()];
        int size = 0;
        for (int temp : ds) {
            array[size++] = temp;
        }

        // 1 ~ 10000까지의 수를 배열에 담기
        int[] numbers = new int[10000];
        for (int i = 1; i <= 10000; i++) {
            numbers[i-1] = i;
        }
        // array와 numbers의 숫자들 중에 겹치는 것 제거
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (numbers[i] == array[j]) {
                    numbers[i] = 0;
                }
            }
        }
        // 0 제외하고 나머지 numbers 배열에 들어있는 수들 출력
        for (int num : numbers) {
            if (num == 0) {
                continue;
            }
            System.out.println(num);
        }

    }

    static int d(int n) {
        String ntoString = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < ntoString.length(); i++) {
            sum += Character.getNumericValue(ntoString.charAt(i));
        }
        return n + sum;
    }

}