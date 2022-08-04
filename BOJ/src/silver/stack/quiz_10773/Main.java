/*
 * 성공여부: 성공!
 * 풀이시간: 11분
 * 메모: -
 */

package silver.stack.quiz_10773;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> stack = new LinkedList<>();
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0)
				stack.pollLast();
			else
				stack.offerLast(input);
		}

		int result = 0;
		for (int n : stack)
			result += n;

		System.out.println(result);

		br.close();
	}

}
