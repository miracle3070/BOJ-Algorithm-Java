package gold.dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static class Edge {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	static class FromNode implements Comparable<FromNode> { // 다익스트라 최단거리 테이블 갱신용
		int from;
		int weight;

		public FromNode(int from, int weight) {
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(FromNode o) {
			return this.weight - o.weight;
		}
	}

	public static int nodeCnt;
	public static int edgeCnt;
	public static List<Edge>[] graph;
	public static int[] goDistance;
	public static int[] backDistance;
	public static int dest;
	public static final int INF = (int) (1e9);

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		nodeCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		int dest = Integer.parseInt(st.nextToken());
		graph = new ArrayList[nodeCnt + 1];
		goDistance = new int[nodeCnt + 1];
		backDistance = new int[nodeCnt + 1];

		for (int i = 1; i <= nodeCnt; i++)
			graph[i] = new ArrayList<>();
		
		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Edge(to, weight));
		}
		
		
		
		for(int i=1; i<=nodeCnt; i++) {
			if(i == dest)
				continue;
			goDistance[i] = dijkstra2(i, dest);
		}
		
		for (int i = 0; i <= nodeCnt; i++)
			backDistance[i] = INF;

		dijkstra(dest);
		int result = 0;
		for (int i = 1; i <= nodeCnt; i++) {
			int cost = goDistance[i] + backDistance[i];
			if (result < cost)
				result = cost;
		}

		System.out.println(result);
		br.close();
	}

	public static void dijkstra(int start) {
		PriorityQueue<FromNode> q = new PriorityQueue<>();
		q.offer(new FromNode(start, 0));
		backDistance[start] = 0;

		while (!q.isEmpty()) {
			FromNode now = q.poll();
			if (now.weight > backDistance[now.from])
				continue;

			for (Edge linked : graph[now.from]) {
				int cost = now.weight + linked.weight;
				if (backDistance[linked.to] > cost) {
					backDistance[linked.to] = cost;
					q.offer(new FromNode(linked.to, cost));
				}
			}
		}
	}

	public static int dijkstra2(int start, int end) {
		if (start == end)
			return -1;

		int[] distance = new int[nodeCnt + 1];
		for (int i = 0; i <= nodeCnt; i++)
			distance[i] = INF;

		PriorityQueue<FromNode> q = new PriorityQueue<>();
		q.offer(new FromNode(start, 0));
		distance[start] = 0;

		while (!q.isEmpty()) {
			FromNode now = q.poll();
			if (now.weight > distance[now.from])
				continue;

			for (Edge linked : graph[now.from]) {
				int cost = now.weight + linked.weight;
				if (distance[linked.to] > cost) {
					distance[linked.to] = cost;
					q.offer(new FromNode(linked.to, cost));
				}
			}
		}

		return distance[end];
	}

}
