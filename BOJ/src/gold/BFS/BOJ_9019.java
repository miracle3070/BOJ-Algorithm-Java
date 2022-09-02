// 성공!
package gold.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
	static class Number {
		int[] numArr;
		int num;
		String oper;

		public Number(int num, String oper) {
			this.numArr = new int[4];
			this.num = num;
			this.oper = oper;

			int k = 0;
			for (int i = 1000; i > 0; i /= 10) {
				numArr[k] = num / i;
				k++;
			}
		}
	}

	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int origin = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			visited = new boolean[10_001];
			BFS(origin, target);
		}

	}

	public static void BFS(int origin, int target) {
		Queue<Number> q = new ArrayDeque<>();
		q.offer(new Number(origin, ""));
		visited[origin] = true;

		while (!q.isEmpty()) {
			Number now = q.poll();
			if (now.num == target) {
				System.out.println(now.oper);
				return;
			}

			operD(q, now);
			operS(q, now);
			operL(q, now);
			operR(q, now);
		}
	}

	public static void operD(Queue<Number> q, Number now) {
		int n = now.num;
		n = (n * 2) % 10_000;
		
		if(!visited[n]) {
			visited[n] = true;
			q.offer(new Number(n, now.oper + "D"));
		}
			
	}

	public static void operS(Queue<Number> q, Number now) {
		int n = now.num;
		if (n > 0)
			n--;
		else
			n = 9999;
		
		if(!visited[n]) {
			visited[n] = true;
			q.offer(new Number(n, now.oper + "S"));
		}
	}

	public static void operL(Queue<Number> q, Number now) {
		int n = now.num;
		n = (n % 1000) * 10 + (n / 1000);
		
		if(!visited[n]) {
			visited[n] = true;
			q.offer(new Number(n, now.oper + "L"));
		}
	}

	public static void operR(Queue<Number> q, Number now) {
		int n = now.num;
		n = (n % 10) * 1000 + (n / 10);
		
		if(!visited[n]) {
			visited[n] = true;
			q.offer(new Number(n, now.oper + "R"));
		}
	}

}
