/*
 * 성공여부: 성공!
 * 풀이시간: 14분
 * 메모: -
 */

package silver.stack.quiz_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		String str;
		Deque<Character> stack = new LinkedList<>();
		
		for(int i=0; i<testCase; i++) {
			stack.clear();
			str = br.readLine();
			for(char ch : str.toCharArray()) {
				if(stack.isEmpty()) {
					stack.add(ch);
				} else if (ch == ')' && stack.peekLast() == '('){
					stack.pollLast();
						
				} else {
					stack.add(ch);
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
	}
}
