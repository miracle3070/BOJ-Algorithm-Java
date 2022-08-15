// 성공여부: 성공!
// 풀이시간: 7분
// 메모: -

package bronze.math.quiz_1037;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] numbers = new int[cnt];
		
		for(int i=0; i<cnt; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		int result;
		if(cnt == 1)
			result = numbers[0] * numbers[0];
		else
			result = numbers[0] * numbers[cnt-1];
		
		System.out.println(result);
	}

}
