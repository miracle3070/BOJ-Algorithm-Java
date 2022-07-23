/*
 * 성공여부: 성공!
 * 풀이시간: 22분
 * 메모: for문 변수 초기화를 잘못해서 오래걸림.
 */

package silver.string.quiz_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		int[] check = null;
		int idx = 0;
		boolean flag = false;
		String str = null;
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			check = new int[26];
			flag = true;
			for(int k=0; k<str.length(); k++) {
				idx = str.charAt(k) - 'a';
				if(check[idx] == 1) {
					flag = false;
					break;
				} else {
					check[idx] = 1;
					for(int c=k+1; c<str.length(); c++) {
						if(str.charAt(k) == str.charAt(c))
							k++;
						else
							break;
					}				
				}
			}
			if (flag) {
				result++;
			}
		}
		 System.out.println(result);
	}

}
