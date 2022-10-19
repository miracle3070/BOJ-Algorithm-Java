package gold.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
	}

	public static int rowSize;
	public static int colSize;
	public static int[][] map;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static Queue<Pos> edges = new ArrayDeque<>();

	public static int spendTime = 0;
	public static int remainCnt = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new int[rowSize][colSize];

		for (int r = 0; r < rowSize; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < colSize; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1)
					remainCnt++;
			}
		}

		meltCheese();
		System.out.println(spendTime);
		System.out.println(remainCnt);
	}
	
	public static void meltCheese() {
		while(remainCnt > 0) {
			BFS();
			
			spendTime++;
			if(remainCnt - edges.size() > 0)
				remainCnt -= edges.size();
			else
				return;
			
			while(!edges.isEmpty()) {
				Pos now = edges.poll();
				map[now.r][now.c] = 0; 
			}
			
		}
	}
	
	public static void BFS() {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(0, 0));
		boolean[][] visited = new boolean[rowSize][colSize];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < rowSize && 0 <= nc && nc < colSize) {
					if(visited[nr][nc])
						continue;
					
					if(map[nr][nc] == 1)
						edges.offer(new Pos(nr, nc));
					else
						q.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
	}

}
