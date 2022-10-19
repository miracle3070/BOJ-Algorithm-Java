// 해결 (풀이참고)

package gold.DFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠 {
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static final int MAP_SIZE = 9;
	public static int[][] map;
	public static boolean end = false;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[MAP_SIZE][MAP_SIZE];

		for (int r = 0; r < MAP_SIZE; r++) {
			String row = br.readLine();
			for (int c = 0; c < MAP_SIZE; c++) {
				map[r][c] = row.charAt(c) - '0';
			}
		}

		calcSudoku(0);
		StringBuilder result = new StringBuilder();
		for (int[] row : map) {
			for (int num : row)
				result.append(num);
			result.append('\n');
		}

		System.out.print(result);
	}

	public static void calcSudoku(int depth) {
		if (depth == 81) {
			end = true;
			return;
		}

		int r = depth / 9;
		int c = depth % 9;

		if (map[r][c] != 0)
			calcSudoku(depth + 1);
		else {
			for (int i = 1; i < 10; i++) {
				if (!checkArea(r, c, i))
					continue;
				map[r][c] = i;
				calcSudoku(depth + 1);
				if (end)
					return;
				map[r][c] = 0;
			}
		}
	}

	private static boolean checkArea(int r, int c, int comp) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == comp || map[i][c] == comp)
				return false;
		}

		int rr = r / 3 * 3;
		int cc = c / 3 * 3;
		for (int a = rr; a < rr + 3; a++) {
			for (int b = cc; b < cc + 3; b++) {
				if (map[a][b] == comp)
					return false;
			}
		}
		return true;
	}

}
