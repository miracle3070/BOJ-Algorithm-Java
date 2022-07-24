/*
 * 성공여부: 성공!
 * 풀이시간: 10분
 * 메모: -
 */

package silver.math.quiz_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int m = Integer.parseInt(strArr[0]);
		int n = Integer.parseInt(strArr[1]);
		int[] notPrime = new int[n+1];
		
		notPrime[0] = 1;
		notPrime[1] = 1;
		
		// 에라토스테네스 체
		for(int i=2; i<n+1; i++) {
			if(notPrime[i] == 1)
				continue;
			else {
				for(int k=2; k<n/2+1; k++) {
					if((i*k) > n)
						break;
					notPrime[i*k] = 1;
				}
			}
		}
		
		// 결과값 출력
		StringBuilder sb = new StringBuilder();
		for(int i=m; i<n+1; i++) {
			if(notPrime[i] == 0) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
		
	}

}
