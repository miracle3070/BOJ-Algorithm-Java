/*
 * 성공여부: 성공!
 * 풀이시간: 12분
 * 메모: -
 */


package silver.implementation.quiz_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] notPrime = new int[1001];
		
		// 에라토스테네스의 체 알고리즘 적용
		notPrime[0] = 1;
		notPrime[1] = 1;
		for(int i=2; i<1001; i++) {
			if(notPrime[i] == 1)
				continue;
			
			for(int k=2; i*k<1001; k++) {
				notPrime[i*k] = 1;
			}
		}
		
		// 개수, 숫자 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split(" ");
		
		// 소수 판별
		int result = 0;
		int num = 0;
		for(String numStr : strArr) {
			num = Integer.parseInt(numStr);
			if(notPrime[num] == 0)
				result++;
		}
		
		System.out.println(result);		
	}
	
}
