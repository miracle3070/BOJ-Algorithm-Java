/*package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static class Shark {
		int r; // 행 위치
		int c; // 열 위치
		int speed; // 속력
		int dir; // 이동 방향
		int size; // 크기

		public Shark(int r, int c, int speed, int dir, int size) {
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(r + c + speed + dir + size);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Shark) {
				Shark shark = (Shark) obj;
				return (this.r == shark.r && this.c == shark.c && this.speed == shark.speed && this.dir == shark.dir
						&& this.size == shark.size);
			}
			return false;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", speed=" + speed + ", dir=" + dir + ", size=" + size + "]";
		}

	}

	public static final int UP = 0;
	public static final int DOWN = 2;
	public static final int LEFT = 1;
	public static final int RIGHT = 3;

	public static int rowSize;
	public static int colSize;
	public static int sharkCnt;
	public static int result = 0;
	public static Shark[][] map;
	public static Queue<Shark> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		sharkCnt = Integer.parseInt(st.nextToken());
		map = new Shark[rowSize + 1][colSize + 1];

		for (int i = 0; i < sharkCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			if (dir == 1)
				dir = UP;
			else if (dir == 2)
				dir = DOWN;
			else if (dir == 3)
				dir = RIGHT;
			else
				dir = LEFT;

			Shark shark = new Shark(r, c, speed, dir, size);
			q.offer(shark);
			map[r][c] = shark;
		}
		
		moveFisherMan();
		System.out.println(result);

	}

	public static void moveFisherMan() {
		int fisherR = 0;
		int fisherC = 0;
		for (; fisherC <= colSize; fisherC++) {
			result += catchShark(fisherR, fisherC);
			moveShark();
		}
	}

	public static int catchShark(int r, int c) {
		int sharkSize = 0;
		
		for (int rr = r + 1; rr < rowSize; rr++) {
			if(map[rr][c] != null) {
				Shark shark = map[rr][c];
				map[rr][c] = null;
				
				sharkSize = shark.size;
				q.remove(shark);
			}
		}
		
		return sharkSize;
	}
	

	private static void moveShark() {
		Queue<Shark> movedQ = new ArrayDeque<>();
		while(!q.isEmpty()) {
			Shark now = q.poll();
			map[now.r][now.c] = null;

			int temp;
			switch(now.dir) {
			case UP:
				temp = now.r - now.speed;
				if(temp < 0) {
					now.r = rowSize + (now.r - now.speed) % rowSize;
					now.dir = DOWN;
				}				
				else
					now.r = temp;
				break;
				
			case DOWN:
				temp = now.r + now.speed;
				if(temp > rowSize) {
					now.r = rowSize - (now.r + now.speed) % rowSize;
					now.dir = UP;
				}
				else
					now.r = temp;
				break;
				
			case LEFT:
				temp = now.c - now.speed;
				if(temp < 0) {
					temp = colSize + (now.c - now.speed) % colSize;
					if((now.c + now.speed) / colSize % 2 == 1)
						now.dir = RIGHT;
					now.c = temp;
				}				
				else
					now.c = temp;
				break;
				
			case RIGHT:
				temp = now.c + now.speed;
				if(temp > colSize) {
					now.c = colSize - (now.c + now.speed) % colSize;
					now.dir = LEFT;
				}
				else
					now.c = temp;
				break;
			}
			
			movedQ.offer(now);
		}
		
		for(Shark shark : movedQ) {
			if(map[shark.r][shark.c] != null) {
				Shark comp = map[shark.r][shark.c];
				if(shark.size < comp.size) {
					continue;
				} else {
					map[shark.r][shark.c]= shark;
					q.remove(comp);
					q.offer(shark);
				}
			} else {
				map[shark.r][shark.c] = shark;
				q.offer(shark);
			}
		}
		
	}
	
	public static int calcSharkPos(Shark shark) {
		switch(shark.dir){
		case UP:
			for(int s=1; s<=shark.speed; s++) {
				shark.r -= 1;
				if(shark < 1)
					
			}
			
			
			
		}
	}
}
*/