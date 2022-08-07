/*
 * 성공여부: 실패 (시간초과)
 * 풀이시간: 15분
 * 메모: 범위안에 포함되는 모든 수를 소수인지 판별하는 알고리즘은 당연히 시간초과 발생..
 */

package gold.math.quiz_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxNum = (int) Math.pow(10, n);
		int startNum = maxNum / 10 * 2;
		StringBuilder st = new StringBuilder();

		for (int num = startNum; num < maxNum; num++) {
			int target = num;
			boolean breakFlag = false;
			System.out.println(num);
			
			while(target > 0) {
				for(int i = 2; i < (int)Math.sqrt(target) + 1; i++) {
					if(target % i == 0) {
						breakFlag = true;
						break;
					}
				}
				target /= 10;
			}
			
			if(!breakFlag) {
				st.append(num).append('\n');
			}
		}
		
		System.out.println(st);

	}

}
