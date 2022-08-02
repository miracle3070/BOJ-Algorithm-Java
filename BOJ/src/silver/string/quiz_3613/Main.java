/*
 * 성공여부: 성공... (반례를 참고함)
 * 풀이시간: 33분
 * 메모: 문제 조건에 위배되는 반례들을 찾아내는 연습을 하자.
 */

package silver.string.quiz_3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		String result = "";
		boolean errorFlag = false;
		
		char startCh = str.charAt(0);
		char endCh = str.charAt(str.length()-1);
		if ('A' <= startCh && startCh <= 'Z') {
			errorFlag = true;
		}
		else if (str.startsWith("_") || str.endsWith("_")){
			errorFlag = true;
		}
		else if (str.contains("__")) {
			errorFlag = true;
		}		
		else if(str.contains("_")) {
			StringTokenizer st = new StringTokenizer(str, "_");
			
			while (st.hasMoreTokens()) {
				String temp = st.nextToken();
				for(int i=0; i<temp.length(); i++) {
					if('A' <= temp.charAt(i) && temp.charAt(i) <= 'Z') {
						errorFlag = true;
						break;
					}
				if(errorFlag)
					break;
				}
				temp = temp.substring(0,1).toUpperCase() + temp.substring(1);
				sb.append(temp);
			}
			
			
			if(!errorFlag) {
				result = sb.toString();
				result = result.substring(0,1).toLowerCase() + result.substring(1);
			}
			
		} else {
			int diff = 'a' - 'A';
			for(char ch : str.toCharArray()) {
				if ('a' <= ch && ch <= 'z') {
					sb.append(ch);
				} else {
					sb.append('_').append((char)(ch+diff));
				}
			}
			result = sb.toString();
		}
		
		if(errorFlag)
			System.out.println("Error!");
		else
			System.out.println(result);
		
	}

}
