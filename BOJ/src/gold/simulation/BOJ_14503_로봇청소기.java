// 해결완료!
// 풀이시간: 43분
// 메모: map 정보를 입력받는걸 깜빡해서 삽질함.

package gold.simulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static class Robot {
		int r; // 세로 위치
		int c; // 가로 위치
		int d; // 방향

		public Robot(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	// 방향을 나타내는 상수
	public static final int UP = 0; // 북
	public static final int right = 1; // 동
	public static final int DOWN = 2; // 남
	public static final int LEFT = 3; // 서

	public static int[] dr = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	public static int[] dc = { 0, 1, 0, -1 };

	public static int rowSize;
	public static int colSize;
	public static int[][] map;
	public static Robot robot;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 세로의 크기, 가로의 크기 입력받음.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		map = new int[rowSize][colSize];

		// 로봇의 현재 위치, 방향 입력받음.
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		robot = new Robot(r, c, d);
		
		for(int a=0; a<rowSize; a++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int b=0; b<colSize; b++) {
				map[a][b] = Integer.parseInt(st.nextToken());
			}
		}
		
		simulate(); // 시뮬레이션 진행

		System.out.println(result); // 최종결과 출력
		br.close();
	}

	public static void simulate() {
		// 현재 위치 청소
		if (map[robot.r][robot.c] == 0) {
			map[robot.r][robot.c] = 2;
			result++;
		}

		while (true) {
			boolean isFound = false; // 청소할 영역을 찾은 경우를 체크
			// 왼쪽 방향 탐색시작
			int d = robot.d;
			for(int i=0; i<4; i++) {
				d = (d + 4 - 1) % 4; // 왼쪽 방향으로 회전
				int nr = robot.r + dr[d];
				int nc = robot.c + dc[d];
				
				if(map[nr][nc] == 0) { // 청소할 공간 발견
					isFound = true;
					break;
				}
			}
			
			// 청소할 공간을 찾은 경우
			if(isFound) {
				robot.d = d;
				robot.r += dr[d];
				robot.c += dc[d];
				map[robot.r][robot.c] = 2;
				result++;
			} else { // 청소할 공간을 못찾은 경우
				// 뒤로 후진할 수 있으면 후진하고 다시 탐색
				int nd = (robot.d - 2 + 4) % 4;	// 후진할 방향 구하기
				int nr = robot.r + dr[nd];
				int nc = robot.c + dc[nd];
				if(map[nr][nc] != 1) { // 후진할 방향이 벽이 아닌 경우 후진!
					robot.r = nr;
					robot.c = nc;
					continue;
				} else {// 후진할 수 없는 경우 탐색 종료
					return;
				}
			}
		}
	}

}
