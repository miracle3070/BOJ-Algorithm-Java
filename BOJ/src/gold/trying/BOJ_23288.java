package gold.trying;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23288 {
	public static int rowSize;
	public static int colSize;
	public static int moveCnt;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		moveCnt = Integer.parseInt(st.nextToken());
		
		map = new int[rowSize][colSize];
		
		for(int r=0; r<rowSize; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<colSize; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
				
		
	}

}
