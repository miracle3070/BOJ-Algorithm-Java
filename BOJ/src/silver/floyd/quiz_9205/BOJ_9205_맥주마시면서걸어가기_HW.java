package silver.floyd.quiz_9205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기_HW {
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		List<Point> points;

		for (int i = 0; i < testCase; i++) {
			points = new ArrayList<>();
			int storeCnt = Integer.parseInt(br.readLine());
			boolean[][] memory = new boolean[storeCnt + 2][storeCnt + 2];
			for (int k = 0; k < storeCnt + 2; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				points.add(new Point(r, c));
			}

			for (int a = 0; a < storeCnt + 2; a++) {
				for (int b = a + 1; b < storeCnt + 2; b++) {
					Point p1 = points.get(a);
					Point p2 = points.get(b);
					int dist = getDistance(p1, p2);
					if (dist <= 1000) {
						memory[a][b] = memory[b][a] = true;
					}
				}
			}

			for (int k = 0; k < storeCnt + 2; k++) {
				for (int a = 0; a < storeCnt + 2; a++) {
					for (int b = 0; b < storeCnt + 2; b++) {
						if (memory[a][k] && memory[k][b])
							memory[a][b] = true;
					}
				}
			}
			System.out.println(memory[0][storeCnt+1] ? "happy" : "sad");
		}
	}

	public static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}
}
