package silver.stack.quiz_10799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();
		int cnt = 0;
		char prevCh = '\0';
		
		for(char ch : str.toCharArray()) {
			if(ch == '(') {
				stack.addLast('(');
				prevCh = '(';
			}
			else if (ch == ')' && prevCh == '(') {
				stack.pollLast();
				cnt += stack.size();
				prevCh = ')';
			} else {
				stack.pollLast();
				cnt += 1;
				prevCh = ')';
			}
		}
		
		System.out.println(cnt);
	}

}
