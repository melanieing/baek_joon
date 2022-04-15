package condition;

import java.util.Arrays;
import java.util.Scanner;
// bj2480 three dices
// soft coding version
public class Dice2480 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int BASEPRICE1 = 10000;
		final int BASEPRICE2 = 1000;
		final int BASEPRICE3 = 100;	
		
		int[] dices = new int[3];
		for (int i = 0; i < dices.length; i++) {
			dices[i] = sc.nextInt();
		}
		sc.close();
		Arrays.sort(dices);
		int maxDice = dices[2];
		int price = 0;
		
		if ((dices[0] == dices[1]) && (dices[1] == dices[2])) {
			price = BASEPRICE1 + dices[0] * BASEPRICE2;
		} else if (((dices[0] == dices[1]) && (dices[1]!= dices[2])) || ((dices[0] == dices[2]) && (dices[1] != dices[2]))) {
			price = BASEPRICE2 + dices[0] * BASEPRICE3;		
		} else if ((dices[1] == dices[2]) && (dices[0] != dices[1])) {
			price = BASEPRICE2 + dices[1] * BASEPRICE3;		
		} else {
			price = maxDice * BASEPRICE3;
		}	
		System.out.println(price);
	}
}
