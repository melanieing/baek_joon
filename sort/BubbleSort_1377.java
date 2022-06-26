import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort_1377 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정렬할 수 개수
		int N = Integer.parseInt(br.readLine());
		// 길이에 맞는 배열 생성해서 입력값으로 채우기
		Data[] d = new Data[N];
		for (int i = 0; i < N; i++) {
			d[i] = new Data(Integer.parseInt(br.readLine()), i);
		}
		
		// d 배열 정렬(O(nlogn))
		Arrays.sort(d);
		
		int max = 0;
		
		for (int i = 0; i < N; i++) { // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장
			if (max < d[i].index - i) {
				max = d[i].index - i;
			}
		}
		System.out.println(max + 1);
	
	}
}

class Data implements Comparable<Data> {
	
	int value;
	int index;
	
	public Data(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Data o) { // value 기준 오름차순 정렬
		return this.value - o.value;
	}
	
}
