/*
 * 성공여부: 성공!
 * 풀이시간: 9분
 * 메모: -
 */

package silver.queue.quiz_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		Deque<Integer> queue = new LinkedList<>();
		for(int i=1; i <= n; i++) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			queue.pollFirst();			
			Integer temp = queue.pollFirst();
			queue.add(temp);
		}
		
		System.out.println(queue.pollFirst());
	}

}
