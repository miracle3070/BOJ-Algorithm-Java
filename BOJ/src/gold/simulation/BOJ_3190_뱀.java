package gold.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {
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

	static class Dir {
		int time;
		char dir;

		public Dir(int time, char dir) {
			this.time = time;
			this.dir = dir;
		}
	}

	public static final int UP = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int RIGHT = 3;

	public static int[] dr = { -1, 0, 1, 0 };
	public static int[] dc = { 0, -1, 0, 1 };

	public static int mapSize; // 맵의 크기
	public static int appleCnt; // 사과의 개수
	public static int changeCnt; // 방향 전환 횟수
	public static Queue<Dir> changeQ = new ArrayDeque<>();
	public static Deque<Pos> snake = new ArrayDeque<>();
	public static int curDir = RIGHT;
	public static int[][] map;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSize = Integer.parseInt(br.readLine());
		map = new int[mapSize + 1][mapSize + 1];

		appleCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < appleCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		changeCnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < changeCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			changeQ.add(new Dir(time, dir));
		}

		snake.add(new Pos(1, 1));
		while (true) {
			result++;

			Pos head = snake.peekLast();
			int nr = head.r + dr[curDir];
			int nc = head.c + dc[curDir];

			if (!(1 <= nr && nr <= mapSize && 1 <= nc && nc <= mapSize))
				break;

			if (map[nr][nc] == 1) {
				map[nr][nc] = 2;
				snake.addLast(new Pos(nr, nc));
			} else if (map[nr][nc] == 0) {
				map[nr][nc] = 2;
				snake.addLast(new Pos(nr, nc));
				Pos pos = snake.pollFirst();
				map[pos.r][pos.c] = 0;
			} else {
				break;
			}

			if (!changeQ.isEmpty() && result == changeQ.peek().time) {
				if (changeQ.peek().dir == 'L') {
					curDir = (curDir + 1) % 4;
				} else {
					curDir = (curDir - 1 + 4) % 4;
				}
				changeQ.poll();
			}

		}
		System.out.println(result);

	}

}
