package gold.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	public static int areaCnt;
	public static int[] peopleCnt;
	public static List<Integer>[] graph;
	public static Set<Integer> area1 = new HashSet<>();
	public static Set<Integer> area2 = new HashSet<>();
	public static int result = (int) (1e9);

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		areaCnt = Integer.parseInt(br.readLine());
		peopleCnt = new int[areaCnt + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= areaCnt; i++) {
			peopleCnt[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[areaCnt + 1];
		for (int i = 1; i <= areaCnt; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= areaCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int linkCnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < linkCnt; k++) {
				int linked = Integer.parseInt(st.nextToken());
				graph[i].add(linked);
				graph[linked].add(i);
			}
		}

		divideArea(1, 0, 0);
		if(result == (int)(1e9))
			result = -1;
		
		System.out.println(result);
		
		br.close();
	}

	public static void divideArea(int areaNum, int pCnt1, int pCnt2) {
		
		if (areaNum > areaCnt) {

			if (pCnt1 == 0 || pCnt2 == 0)
				return;
			if (Math.abs(pCnt1 - pCnt2) > result)
				return;

			// 각 영역에 속한 노드들이 서로 연결되어 있으면 result값 갱신
			if (BFS(area1) && BFS(area2)) {
				result = Math.abs(pCnt1 - pCnt2);
			}
			return;
		}

		area1.add(areaNum);
		divideArea(areaNum + 1, pCnt1 + peopleCnt[areaNum], pCnt2);
		area1.remove(areaNum);

		area2.add(areaNum);
		divideArea(areaNum + 1, pCnt1, pCnt2 + peopleCnt[areaNum]);
		area2.remove(areaNum);
	}

	public static boolean BFS(Set<Integer> argArea) {
		List<Integer> areaList = new ArrayList<>(argArea);
		Set<Integer> area = new HashSet<>(argArea);
		
		boolean[] visited = new boolean[areaCnt + 1];
		Queue<Integer> q = new ArrayDeque<>();
		
		Integer start = areaList.get(0);
		q.offer(start);
		area.remove(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int linked : graph[now]) {
				if(visited[linked] || !area.contains(linked))
					continue;
				q.offer(linked);
				visited[linked] = true;
				area.remove(linked);
			}
		}
		
		if(area.size() == 0)
			return true;
		else
			return false;
	}

}
