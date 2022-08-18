package silver.bfs.quiz_2644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	public static List<Integer>[] graph;
	public static int[] visited;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int peopleCnt = Integer.parseInt(br.readLine());
		visited = new int[peopleCnt + 1];
		graph = new ArrayList[peopleCnt + 1];
		
		for(int i=1; i<=peopleCnt; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		boolean isFound = BFS(graph, start, end);
		if(isFound)
			System.out.println(result);
		else
			System.out.println(-1);
	}

	public static boolean BFS(List<Integer>[] graph, int start, int end) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = 1;
		result = 0;
		while(!q.isEmpty()) {
			int queueSize = q.size();
			while(--queueSize >= 0) {
				int node = q.poll();
				for(int linked : graph[node]) {
					if(visited[linked] == 1)
						continue;
					if(linked == end) {
						result++;
						return true;
					}
					visited[linked] = 1;
					q.offer(linked);
				}
			}
			result++;
		}
		return false;
	}

}
