package gold.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17780_새로운게임 {

	static enum Color {
		WHITE(0), RED(1), BLUE(2);

		public int num;

		private Color(int num) {
			this.num = num;
		}
	}

	static enum Dir {
		RIGHT(1), LEFT(2), UP(3), DOWN(4);

		public int num;

		private Dir(int num) {
			this.num = num;
		}
	}

	static class Horse {
		int r;
		int c;
		int d;

		public Horse(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static int[] dr = { 10000, 0, 0, -1, 1 };
	public static int[] dc = { 10000, 1, -1, 0, 0 };

	public static int mapSize; // 체스판의 크기
	public static int horseCnt; // 말의 개수
	public static int[][] map;
	public static List<Horse>[][] horseMap;
	public static List<Horse> horseList = new ArrayList<>();
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		mapSize = Integer.parseInt(st.nextToken());
		horseCnt = Integer.parseInt(st.nextToken());
		map = new int[mapSize + 1][mapSize + 1];
		horseMap = new List[mapSize + 1][mapSize + 1];
		for (int r = 1; r <= mapSize; r++) {
			for (int c = 1; c <= mapSize; c++) {
				horseMap[r][c] = new LinkedList<Horse>();
			}
		}

		for (int r = 1; r < mapSize + 1; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c < mapSize + 1; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < horseCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			Horse horse = new Horse(r, c, d);
			horseList.add(horse);
			horseMap[r][c].add(horse);
		}

		Outter: while (true) {
			result++;
			if (result > 1000) {
				result = -1;
				break;
			}

			for (Horse horse : horseList) {
				// 말이 맨 아래에 있는 경우
				if (horseMap[horse.r][horse.c].get(0) == horse) {
					int nr = horse.r + dr[horse.d];
					int nc = horse.c + dc[horse.d];

					// 이동할 칸이 파란색 칸이거나 벽일 경우
					if (!isRange(nr, nc) || map[nr][nc] == Color.BLUE.num) {
						reverseDir(horse);
						nr = horse.r + dr[horse.d];
						nc = horse.c + dc[horse.d];

						if (!isRange(nr, nc) || map[nr][nc] == Color.BLUE.num)
							continue;
					}
					
					// 이동할 칸이 빨간색일 경우
					if (map[nr][nc] == Color.RED.num) {
						reverseHorse(horseMap[horse.r][horse.c]);

						// 이동할 칸이 흰색일 경우
					} else {
						// 아무런 추가작업을 하지 않음.
					}

					// 말을 이동시킨다.
					moveAllHorse(horseMap[nr][nc], horseMap[horse.r][horse.c], nr, nc);

					// 말이 한 곳에 4개 이상 모이면 종료
					if (horseMap[nr][nc].size() >= 4)
						break Outter;

				} else { // 말이 맨 아래가 아닌 경우
					continue;
				}
			}
		}

		System.out.println(result);

	}

	public static boolean isRange(int r, int c) {
		if (1 <= r && r <= mapSize && 1 <= c && c <= mapSize)
			return true;
		else
			return false;
	}

	public static void reverseDir(Horse horse) {
		if (horse.d == Dir.UP.num)
			horse.d = Dir.DOWN.num;
		else if (horse.d == Dir.DOWN.num)
			horse.d = Dir.UP.num;
		else if (horse.d == Dir.LEFT.num)
			horse.d = Dir.RIGHT.num;
		else
			horse.d = Dir.LEFT.num;
	}

	public static void moveAllHorse(List<Horse> dest, List<Horse> src, int r, int c) {
		while (src.size() > 0) {
			Horse horse = src.remove(0);
			horse.r = r;
			horse.c = c;
			dest.add(horse);
		}
	}

	public static void reverseHorse(List<Horse> dq) {
		Collections.reverse(dq);
	}

}
