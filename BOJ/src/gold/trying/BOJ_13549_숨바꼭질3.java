package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	public static final int MAX_SIZE = 100_000;
	public static final int INF = (int) (1e9); // 무한대를 나타내는 상수
	public static int start; // 수빈이의 위치 (N)
	public static int end; // 동생의 위치 (K)
	public static int[] memory = new int[MAX_SIZE + 1];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		Arrays.fill(memory, INF);

		int result = BFS(start);
		System.out.println(result);
	}

	public static int BFS(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		memory[start] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			if(now > 0) {
				for (int i = now * 2; i < MAX_SIZE; i *= 2) {
					if (memory[i] > memory[now]) {
						memory[i] = memory[now];
						q.offer(i);
					}
				}
			}

			if ((now + 1) <= MAX_SIZE && memory[now + 1] > memory[now] + 1) {
				memory[now + 1] = memory[now] + 1;
				q.offer(now + 1);
			}

			if ((now - 1) >= 0 && memory[now - 1] > memory[now] + 1) {
				memory[now - 1] = memory[now] + 1;
				q.offer(now - 1);
			}
		}

		return memory[end];
	}

}
