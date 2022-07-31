/*
 * 성공여부: 실패
 * 풀이시간: 20분
 * 메모: 점화식 세우기가 어려웠다.
 */

package silver.dynamic.quiz_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 계단 수
		int[] stairs = new int[n+1];
		int[] memory = new int[n+1];
		
		for (int i=0; i<n; i++) {
			stairs[i+1] = Integer.parseInt(br.readLine());
		}
		
		if (n == 1) {
			System.out.println(stairs[1]);
		} else if (n == 2) {
			System.out.println(stairs[1] + stairs[2]);
		} /*else {
			// 잘못된 풀이임. 다시 풀 것.
			memory[1] = stairs[1];
			memory[2] = stairs[2];
			for (int i=2; i < (n+1); i++) {
				memory[i] = stairs[i] + Math.max(memory[i-1], memory[i-2]);
			}
			
			System.out.println(memory[n]); 
		} */
		
	}

}
