package gold.kruskal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1922_네트워크_연결 {
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int c;
		
		public Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			return this.c - o.c;
		}
	}
	
	public static int nodeCnt; // 컴퓨터의 수
	public static int edgeCnt; // 연결할 수 있는 선의 수
	public static List<Edge> edges = new ArrayList<Edge>();
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeCnt = Integer.parseInt(br.readLine());
		edgeCnt = Integer.parseInt(br.readLine());
		
		parent = new int[nodeCnt + 1];
		for(int i=1; i<=nodeCnt; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<edgeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}
		
		Collections.sort(edges);
		int result = 0;
		for(Edge edge : edges) {
			if(union(edge.a, edge.b)) {
				result += edge.c;
			}
		}
		
		System.out.println(result);
		br.close();		
	}
	
	public static boolean union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);
		if(parentA == parentB)
			return false;
		
		if(parentA < parentB) {
			parent[parentB] = parentA;
		} else {
			parent[parentA] = parentB;
		}
		
		return true;
	}
	
	public static int findParent(int a) {
		if (parent[a] != a)
			parent[a] = findParent(parent[a]);
		return parent[a];
	}

}
