package gold.implementation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Position {
	int r;
	int c;

	public Position(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BOJ_21610 {
	public static int[][] map;
	public static int[][] check;
	public static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	public static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static int[] cr = { -1, -1, 1, 1 };
	public static int[] cc = { -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strArr = br.readLine().split(" ");
		int mapSize = Integer.parseInt(strArr[0]); // N
		int moveCnt = Integer.parseInt(strArr[1]);
		map = new int[mapSize][mapSize];

		for (int r = 0; r < mapSize; r++) {
			strArr = br.readLine().split(" ");
			for (int c = 0; c < mapSize; c++) {
				map[r][c] = Integer.parseInt(strArr[c]);
			}
		}

		List<Position> cloud = new ArrayList<>();
		cloud.add(new Position(mapSize - 1, 0));
		cloud.add(new Position(mapSize - 1, 1));
		cloud.add(new Position(mapSize - 2, 0));
		cloud.add(new Position(mapSize - 2, 1));

		for (int i = 0; i < moveCnt; i++) {
			strArr = br.readLine().split(" ");
			List<Position> increased = new ArrayList<>();
			int d = Integer.parseInt(strArr[0]);
			int s = Integer.parseInt(strArr[1]);
			check = new int[mapSize][mapSize];

			for (Position c : cloud) {
				int nr = (c.r + dr[d] * s + mapSize * s) % mapSize;
				int nc = (c.c + dc[d] * s + mapSize * s) % mapSize;
				map[nr][nc] += 1;
				check[nr][nc] = 1;
				increased.add(new Position(nr, nc));
			}
			

			for (Position pos : increased) {
				int addWater = 0;
				int r = pos.r;
				int c = pos.c;

				for (int k = 0; k < 4; k++) {
					int nr = r + cr[k];
					int nc = c + cc[k];
					if (0 <= nr && nr < mapSize && 0 <= nc && nc < mapSize) {
						if (map[nr][nc] > 0)
							addWater++;
					}
				}
				map[r][c] += addWater;
			}
			
			cloud.clear();

			for (int r = 0; r < mapSize; r++) {
				for (int c = 0; c < mapSize; c++) {
					if (map[r][c] >= 2 && check[r][c] == 0) {
						map[r][c] -= 2;
						cloud.add(new Position(r, c));
					}
				}
			}
		}
		
		int result = 0;
		for(int r=0; r<mapSize; r++) {
			for(int c=0; c<mapSize; c++)
				result += map[r][c];
		}
		
		System.out.println(result);
	}

}
