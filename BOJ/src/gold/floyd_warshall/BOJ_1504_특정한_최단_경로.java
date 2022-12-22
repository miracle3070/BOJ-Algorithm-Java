// 성공!
// 풀이시간: 50분
// 메모:
//		1. INF 값을 더하면서 오버플로우 발생했던 문제
//		2. 문제를 제대로 읽지 않아서 반드시 1 -> v1 -> v2 -> N 순서로만 방문해야 되는걸로 잘못 이해함.
//		(1 -> v2 -> v1 -> N) 의 순서로 방문해도 되는 조건이었음.

package gold.floyd_warshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1504_특정한_최단_경로 {
	public static int nodeCnt;
	public static int edgeCnt;
	public static final int INF = (int) (1e9);
	public static int[][] graph;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		nodeCnt = Integer.parseInt(st.nextToken());
		edgeCnt = Integer.parseInt(st.nextToken());
		graph = new int[nodeCnt + 1][nodeCnt + 1];
		for (int r = 1; r <= nodeCnt; r++) {
			for (int c = 1; c <= nodeCnt; c++)
				graph[r][c] = INF;
		}
		
		for (int i = 0; i < edgeCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (graph[a][b] > c) {
				graph[a][b] = c;
				graph[b][a] = c;
			}
		}
		
		// 반드시 거쳐야하는 경로
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 플로이드-워셜 수행
		for(int k=1; k<=nodeCnt; k++) {
			for(int a=1; a<=nodeCnt; a++) {
				for(int b=1; b<=nodeCnt; b++)
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
			}
		}
		
		int result1 = 0;
		if(1 != v1)
			result1 += graph[1][v1];
		if(v1 != v2 && result1 < INF)
			result1 += graph[v1][v2];
		if(v2 != nodeCnt && result1 < INF)
			result1 += graph[v2][nodeCnt];
		
		
		int result2 = 0;
		if(1 != v2)
			result2 += graph[1][v2];
		if(v2 != v1 && result2 < INF)
			result2 += graph[v2][v1];
		if(v1 != nodeCnt && result2 < INF)
			result2 += graph[v1][nodeCnt];
		
		int answer = Math.min(result1, result2);
		if(answer >= INF)
			answer = -1;
		System.out.println(answer);
		br.close();

	}

}
