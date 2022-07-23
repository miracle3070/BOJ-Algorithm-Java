/*
 * 성공여부: 성공!
 * 풀이시간: 17분
 * 메모: 문제 풀이 아이디어가 금방 떠오르지 않음. 
 */

package silver.string.quiz_1120;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String[] strArr = str.split(" ");
		String s1 = strArr[0];
		String s2 = strArr[1];
		int diff = s2.length() - s1.length();
		int result = (int)(1e9);
		int cnt = 0;
		
		if(diff == 0) {
			cnt = 0;
			for(int i=0; i < s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i))
					cnt++;
			}
			result = cnt;
		} else {
			for(int k=0; k < diff+1; k++) {
				cnt = 0;
				for(int i=0; i < s1.length(); i++) {
					if(s1.charAt(i) != s2.charAt(i+k))
						cnt++;
				}
				result = Math.min(result, cnt);
			}
		}
		
		System.out.println(result);
	}

}
