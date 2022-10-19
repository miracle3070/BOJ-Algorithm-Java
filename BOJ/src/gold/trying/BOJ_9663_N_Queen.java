package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_N_Queen {
	
	public static int N;
	public static int[][] map;
	public static int result = 0;
	public static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0}; //왼위, 위, 오위, 오, 오하, 하, 왼하, 왼
	public static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = 1;
				putQueen(r, c, 1);
				map[r][c] = 0;
			}
		}
		System.out.println(result);
	}
	
	public static void putQueen(int r, int c, int cnt) {
		if(cnt == N) {
			result++;
			return;
		}
		
		int x = c;
		for(int y=r; y<N; y++) {
			for(; x<N; x++) {
				if(y == r && x == c)
					continue;
				if(canPosition(y, x)) {
					map[y][x] = 1;
					putQueen(y, x, cnt+1);
					map[y][x] = 0;
				}
			}
			x = 0;
		}
	}
	
	public static boolean canPosition(int r, int c) {
		for(int i=0; i<8; i++) {
			int nr = r;
			int nc = c;
			while(0 <= nr && nr < N && 0 <= nc && nc < N) {
				if(map[nr][nc] == 1)
					return false;
				nr += dr[i];
				nc += dc[i];
			}
		}
		return true;
	}

}
