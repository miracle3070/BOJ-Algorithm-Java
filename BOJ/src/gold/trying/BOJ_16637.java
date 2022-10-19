// 미해결

package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_16637 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> operand = new ArrayDeque<>();
		Deque<Character> operator = new ArrayDeque<>();
		
		int cnt = Integer.parseInt(br.readLine());
		String express = br.readLine();
		
		for(int i=0; i<cnt; i++) {
			System.out.println(operand + " " + operator);
			char target = express.charAt(i);
			if ('0' <= target && target <= '9') {
				int temp = target - '0';
				operand.offerLast(temp);
			} else {
				if(target == '*')
					operator.offerLast('*');
				else if (target == '+') {
					if(!operator.isEmpty() && (operator.peekLast() == '.' || operator.peekLast() == '-')) {
						operator.offerLast('+');
						continue;
					}
					int n1 = operand.pollLast();
					int n2 = express.charAt(++i) - '0';
					int temp = n1 + n2;
					operand.offerLast(temp);
					operator.offerLast('.');
				} else {
					if(!operator.isEmpty() && operator.peekLast() == '-') {
						int n1 = operand.peekLast();
						int n2 = express.charAt(++i) - '0';
						int temp = n1 - n2;
						if(temp <= 0) {
							operand.pollLast();
							operand.offerLast(-temp);
							operator.pollLast();
							operator.offerLast('+');
							operator.offerLast('.');							
						} else {
							operator.offerLast('-');
							i--;
						}
						continue;
					}
					operator.add('-');
				}
			}
		}
		
		System.out.println(operand + " " + operator);
		
		int result = operand.pollFirst();
		while(!operator.isEmpty()) {
			int temp;
			char oper = operator.pollFirst();
			if(oper == '.')
				continue;
			else if (oper == '+')
				result += operand.pollFirst();
			else if (oper == '-')
				result -= operand.pollFirst();
			else
				result *= operand.pollFirst();
		}
		
		System.out.println(result);
		
	}

}
