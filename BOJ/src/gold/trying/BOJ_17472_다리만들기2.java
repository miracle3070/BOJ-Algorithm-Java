package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static final int INF = (int)(100);
	public static final int BRIDGE = 200;
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	public static int colSize;
	public static int rowSize;
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<Pos> searchQ;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new int[rowSize][colSize];
		visited = new boolean[rowSize][colSize];
		
		for(int r=0; r<rowSize; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<colSize; c++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1)
					n = INF;
				map[r][c] = n;
			}
		}
		
		outter: for(int r=0; r<rowSize; r++) {
			for(int c=0; c<colSize; c++) {
				if(map[r][c] == INF) {
					fillArea(r, c, 1);
					break outter;
				}
			}
		}
		
		for(int r=0; r<rowSize; r++) {
			for(int c=0; c<colSize; c++) {
				if(map[r][c] != 0 && map[r][c] != BRIDGE && !visited[r][c]) {
					visitArea(r, c);
					searchArea(r, c);
				}
			}
		}
		
		for(int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
		
		int result = 0;
		outter: for(int r=0; r<rowSize; r++) {
			for(int c=0; c<colSize; c++) {
				if(map[r][c] == INF) {
					result = -1;
					break outter;
				}
				if(map[r][c] != BRIDGE && map[r][c] != 0) {
					result += map[r][c];
					removeArea(r, c);
				}
			}
		}
		
		if(result != -1)
			result--;
		
		System.out.println(result);
	}
	
	public static void searchArea(int r, int c) {		
		while(!searchQ.isEmpty()) {
			Pos now = searchQ.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				int length = 1;
				while(0 <= nr && nr < rowSize && 0 <= nc && nc < colSize) {
					if (map[nr][nc] == BRIDGE) {
						break;
					}
					
					else if(map[nr][nc] == 0) {
						map[nr][nc] = BRIDGE;
					}
					
					else if(map[nr][nc] != BRIDGE && map[nr][nc] != 0) {
						if(length <= 2)
							break;						
						if(map[nr][nc] <= length-1)
							break;
						fillArea(nr, nc, length-1);
					}
					
					else {}
					
					nr += dr[i];
					nc += dc[i];
					length++;
				}
			}
			
		}
		
	}
	
	public static void visitArea(int r, int c) {
		Pos start = new Pos(r, c);
		Queue<Pos> q = new ArrayDeque<>();
		searchQ = new ArrayDeque<>();
		q.offer(start);
		searchQ.offer(start);
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < rowSize && 0 <= nc && nc < colSize) {
					if(map[nr][nc] == 0 || map[nr][nc] == BRIDGE || visited[nr][nc])
						continue;
					Pos temp = new Pos(nr, nc);
					q.offer(temp);
					searchQ.offer(temp);
					visited[nr][nc] = true;
				}
			}
		}
		
		
	}
	
	public static void fillArea(int r, int c, int argLength) {
		Pos start = new Pos(r, c);
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		boolean[][] curAreaVisited = new boolean[rowSize][colSize];
		curAreaVisited[r][c] = true;
		map[r][c] = argLength;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < rowSize && 0 <= nc && nc < colSize) {
					if(map[nr][nc] == 0 || map[nr][nc] == BRIDGE || curAreaVisited[nr][nc])
						continue;
					map[nr][nc] = argLength;
					Pos temp = new Pos(nr, nc);
					q.offer(temp);
					curAreaVisited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void removeArea(int r, int c) {
		Pos start = new Pos(r, c);
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(start);
		boolean[][] curAreaVisited = new boolean[rowSize][colSize];
		curAreaVisited[r][c] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(0 <= nr && nr < rowSize && 0 <= nc && nc < colSize) {
					if(map[nr][nc] == 0 || map[nr][nc] == BRIDGE || curAreaVisited[nr][nc])
						continue;
					map[nr][nc] = 0;
					Pos temp = new Pos(nr, nc);
					q.offer(temp);
					curAreaVisited[nr][nc] = true;
				}
			}
		}
	}
}
