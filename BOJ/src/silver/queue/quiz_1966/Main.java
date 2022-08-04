/*
 * 성공여부: 성공!
 * 풀이시간: 45분
 * 메모: 아이디어를 떠올리는게 쉽지 않았음. 
 */

package silver.queue.quiz_1966;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			queue.clear();
			
			st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				queue.offer(temp);
			}
			
			List<Integer> check = new ArrayList<>(queue);
			check.sort(Collections.reverseOrder());
			
			int i=0;
			int result = 0;
			while(!queue.isEmpty()) {
				if(queue.peek() == check.get(i)) {
					queue.poll();
					i++;
					result++;
					if(m == 0)
						break;
					else
						m--;

				} else {
					Integer temp = queue.poll();
					queue.offer(temp);
					m = (m + queue.size() - 1) % queue.size();
				}				
			}
			
			System.out.println(result);

		}
		
	}
}
