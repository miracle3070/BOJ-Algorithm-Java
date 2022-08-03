/*
 * 성공여부: 성공
 * 메모: 이전 풀이가 더 깔끔함.
 */

package silver.stack.quiz_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main_re {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Deque<Character> stack = new LinkedList<>();
		
		for(int testCase = 0; testCase < t; testCase++) {
			String str = br.readLine();
			boolean breakFlag = false;
			for(char ch : str.toCharArray()) {
				if (ch == '(')
					stack.add('(');
				else {
					if(stack.isEmpty()) {
						breakFlag = true;
						break;
					}						
					stack.pollLast();
				}
			}
			
			// 결과 출력
			if(stack.isEmpty() && !breakFlag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			stack.clear();
		}
		br.close();
	}

}
