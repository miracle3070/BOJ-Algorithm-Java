package silver.bfs.quiz_11725;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725 {
	public static int[] parents;
	public static List<Integer>[] graph;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nodeCnt = Integer.parseInt(br.readLine());
		parents = new int[nodeCnt+1];
		visited = new boolean[nodeCnt+1];
		graph = new ArrayList[nodeCnt+1];
		for(int i=1; i<=nodeCnt; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<nodeCnt-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		BFS(1);
		
		StringBuilder resultString = new StringBuilder();
		for(int i = 2; i <= nodeCnt; i++) {
			resultString.append(parents[i]).append('\n');
		}
		System.out.println(resultString);
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int linked : graph[now]) {
				if(visited[linked])
					continue;
				parents[linked] = now;
				visited[linked] = true;
				q.offer(linked);
			}
		}
	}

}
