/*
 * 성공여부: 성공!
 * 풀이시간: 13분
 * 메모: char형 변수에서 비교할 것은 1이 아니라 '1'이다!
 */

package silver.string.quiz_1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int zeroArea = 0;
		int oneArea = 0;
		char target = s.charAt(0);
		
		if(target == '0') {
			zeroArea++;
		} else {
			oneArea++;
		}
		
		for(int i=0; i < s.length(); i++) {
			if(target == s.charAt(i))
				continue;
			else {
				if(s.charAt(i) == '0') {
					target = '0';
					zeroArea++;
				} else {
					target = '1';
					oneArea++;
				}
			}
		}
		
		System.out.println(Math.min(zeroArea, oneArea));
		
	}

}
