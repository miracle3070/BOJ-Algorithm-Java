/*
 * 성공여부: 성공!
 * 풀이시간: 16분
 * 메모: 자료구조와 관련된 컬렉션 프레임워크 사용법에 좀 더 익숙해질 것!
 */

package silver.stack.quiz_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str; // 입력받은 문자열
		String cmd; // 명령 단어
		String num; // 인수
		String[] temp;
		
		Deque<String> stack = new LinkedList<String>();
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			temp = str.split(" ");
			if (temp.length > 1) {
				cmd = temp[0];
				num = temp[1];
				
				if (cmd.equals("push")) {
					stack.add(num);
				}
				
			} else {
				cmd = str;
				if(cmd.equals("pop")) {
					if(stack.isEmpty())
						System.out.println(-1);
					else
						System.out.println(stack.pollLast());
					
				} else if (cmd.equals("size")) {
					System.out.println(stack.size());
					
				} else if (cmd.equals("empty")) {
					if(stack.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
					
				} else {
					if(stack.isEmpty())
						System.out.println(-1);
					else
						System.out.println(stack.peekLast());
				}	
			}
		}
	}

}
