/*
 * 성공여부: 성공
 * 풀이시간: 36분
 * 메모: 문자열 처리 & 구현이 엄청 힘들었다.
 */

package silver.string.quiz_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		br.close();
		
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<name.length(); i++) {
			Integer cnt = map.get(name.charAt(i));
			if (cnt == null)
				cnt = 0;
			map.put(name.charAt(i), cnt+1);			
		}
		
		int oddCount = 0;
		for(Integer cnt : map.values()) {
			if(cnt % 2 == 1)
				oddCount++;
			if(oddCount >= 2)
				break;
		}
		
		if (oddCount >= 2)
			System.out.println("I'm Sorry Hansoo");
		else {
		
			char[] nameArr = name.toCharArray();
			Arrays.sort(nameArr);
			StringBuilder start = new StringBuilder();
			StringBuilder end = new StringBuilder();
			StringBuilder mid = new StringBuilder();
			
			if(nameArr.length % 2 == 0) {
				for(int i=0; i < nameArr.length; i+=2) {
					start.append(nameArr[i]);
					end.append(nameArr[i+1]);
				}				
			} else {
				int i = 0;
				for(; i < nameArr.length; i+=2) {
					if((i+1) >= nameArr.length)
						break;					
					if(nameArr[i] == nameArr[i+1]) {
						start.append(nameArr[i]);
						end.append(nameArr[i+1]);
					} else {
						break;
					}
				}
				mid.append(nameArr[i]);
				i++;
				for(; i < nameArr.length; i+=2) {
					if(nameArr[i] == nameArr[i+1]) {
						start.append(nameArr[i]);
						end.append(nameArr[i+1]);
					} else {
						break;
					}
				}
			}
			end.reverse();
			String result = start.toString() + mid.toString() + end.toString();
			System.out.println(result);
		}
		
	}
}
