package silver.bfs.quiz_2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static class Pos{
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static int mapSize;
	public static int[][] map;
	public static boolean[][] check;	// 안전지대 체크
	public static int result = 1;
	public static int[] dr = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minHeight = 100;
		int maxHeight = 1;

		mapSize = Integer.parseInt(br.readLine());
		map = new int[mapSize][mapSize];

		for (int r = 0; r < mapSize; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < mapSize; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] > maxHeight) {
					maxHeight = map[r][c];
				} else if (map[r][c] < minHeight) {
					minHeight = map[r][c];
				} else {
				}
			}
		}

		for (int h = minHeight; h <= maxHeight; h++) {
			check = new boolean[mapSize][mapSize];
			int cnt = 0;
			for(int r=0; r<mapSize; r++) {
				for(int c=0; c<mapSize; c++) {
					if(map[r][c] > h && check[r][c] == false) {
						BFS(r, c, h);
						cnt++;
					}
				}
			}
			if(result < cnt)
				result = cnt;
		}
		System.out.println(result);
	}
	
	public static void BFS(int r, int c, int h) {
		Queue<Pos> q = new ArrayDeque<>();
		check[r][c] = true;
		q.offer(new Pos(r, c));
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < mapSize && 0 <= nc && nc < mapSize) {
					if(map[nr][nc] > h && check[nr][nc] == false) {
						check[nr][nc] = true;
						q.offer(new Pos(nr, nc));
					}
				}
			}
		}
	}

}
