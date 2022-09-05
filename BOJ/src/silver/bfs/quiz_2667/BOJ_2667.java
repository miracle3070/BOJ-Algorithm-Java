package silver.bfs.quiz_2667;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int cnt;
	public static int[][] map;
	public static int mapSize;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSize = Integer.parseInt(br.readLine());
		map = new int[mapSize][mapSize];
		
		for (int r = 0; r < mapSize; r++) {
			String str = br.readLine();
			for (int c = 0; c < mapSize; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		int danziCnt = 0; // 단지수
		List<Integer> result = new ArrayList<>();
		for (int r = 0; r < mapSize; r++) {
			for (int c = 0; c < mapSize; c++) {
				if (map[r][c] == 1) {
					danziCnt++;
					cnt = 0;
					BFS(r, c);
					result.add(cnt);
				}
			}
		}
		Collections.sort(result);
		System.out.println(danziCnt);
		for(Integer n : result) {
			System.out.println(n);
		}
	}

	public static void BFS(int r, int c) {
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(new Node(r, c));
		map[r][c] = 2;
		cnt = 1;

		while (!q.isEmpty()) {
			Node now = q.poll();
			for(int i=0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < mapSize && 0 <= nc && nc < mapSize) {
					if(map[nr][nc] == 1) {
						cnt++;
						map[nr][nc] = 2;
						q.offer(new Node(nr, nc));
					}
				}
			}
		}
	}

}
