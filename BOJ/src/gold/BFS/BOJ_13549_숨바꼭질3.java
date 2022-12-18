package gold.BFS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	static class Pos {
		int pos;
		int time;
		
		public Pos(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}
	
	public static final int MAX_LENGTH = 100_000;
	public static int[] map = new int[MAX_LENGTH + 1];
	public static int start;
	public static int target;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		Arrays.fill(map, Integer.MAX_VALUE);
		
		BFS(start);
		System.out.println(map[target]);
		br.close();
	}
	
	public static void BFS(int start) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(start, 0));
		
		while(!q.isEmpty()) {
			Pos cur = q.poll();
			if(cur.time > map[cur.pos])
				continue;
			
			map[cur.pos]= cur.time;
			if(cur.pos - 1 >= 0)
				q.offer(new Pos(cur.pos-1, cur.time+1));
			if(cur.pos + 1 <= MAX_LENGTH)
				q.offer(new Pos(cur.pos+1, cur.time+1));
			
			for(int p = cur.pos * 2; p <= MAX_LENGTH; p *= 2) {
				if(map[p] <= cur.time)
					break;
				map[p] = cur.time;
				q.offer(new Pos(p, cur.time));
			}
		}
	}

}
