package silver.bruteforce.quiz_7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int peopleCnt = Integer.parseInt(br.readLine());
		int[] weights = new int[peopleCnt];
		int[] heights = new int[peopleCnt];
		
		for(int i=0; i<peopleCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			weights[i] = weight;
			heights[i] = height;	
		}
		
		int[] result = new int[peopleCnt];
		for(int i=0; i<peopleCnt; i++) {
			int rank = 1;
			for(int k=0; k<peopleCnt; k++) {
				if(i == k)
					continue;
				if(weights[i] < weights[k] && heights[i] < heights[k])
					rank++;
			}
			result[i] = rank;
		}
		
		for(int r : result) {
			System.out.print(r + " ");
		}
	}
}
