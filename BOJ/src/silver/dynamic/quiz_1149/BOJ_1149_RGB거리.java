// 참고한 풀이: https://st-lab.tistory.com/128
// 다시 풀어볼 것!

package silver.dynamic.quiz_1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static final int RED = 0;
	public static final int GREEN = 1;
	public static final int BLUE = 2;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int houseCnt = Integer.parseInt(br.readLine());
		int[][] costs = new int[houseCnt][3];
		int[][] memory = new int[houseCnt][3];
		
		for(int i=0; i<houseCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			costs[i][RED] = Integer.parseInt(st.nextToken());
			costs[i][GREEN] = Integer.parseInt(st.nextToken());
			costs[i][BLUE] = Integer.parseInt(st.nextToken());
		}
		
		memory[0][RED] = costs[0][RED];
		memory[0][GREEN] = costs[0][GREEN];
		memory[0][BLUE] = costs[0][BLUE];
		
		for(int i=1; i<houseCnt; i++) {
			memory[i][RED] = costs[i][RED] + Math.min(memory[i-1][GREEN], memory[i-1][BLUE]);
			memory[i][GREEN] = costs[i][GREEN] + Math.min(memory[i-1][RED], memory[i-1][BLUE]);
			memory[i][BLUE] = costs[i][BLUE] + Math.min(memory[i-1][RED], memory[i-1][GREEN]);
		}
		
		int result = Math.min(memory[houseCnt-1][RED], memory[houseCnt-1][GREEN]);
		result = Math.min(result, memory[houseCnt-1][BLUE]);
		System.out.println(result);
	}
}
