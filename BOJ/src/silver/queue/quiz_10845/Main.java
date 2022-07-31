/*
 * 성공여부: 성공!
 * 풀이시간: 16분
 * 메모: Deque<E>은 인터페이스에 불과하다!
 */

package silver.queue.quiz_10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 명령어 수
		String[] strArr;
		String cmd;
		
		Deque<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<n; i++) {
			cmd = br.readLine();
			
			if (cmd.contains("push")) {
				strArr = cmd.split(" ");
				queue.addLast(Integer.valueOf(strArr[1]));
				
			} else {
				switch(cmd) {
				case "pop":
					if(queue.isEmpty())
						System.out.println(-1);
					else
						System.out.println(queue.pollFirst());
					break;
					
				case "size":
					System.out.println(queue.size());
					break;
					
				case "empty":
					if(queue.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
					break;
					
				case "front":
					if(queue.isEmpty())
						System.out.println(-1);
					else
						System.out.println(queue.peekFirst());
					break;
					
				case "back":
					if(queue.isEmpty())
						System.out.println(-1);
					else
						System.out.println(queue.peekLast());
					break;
				}
				
			}
		}
	}

}
